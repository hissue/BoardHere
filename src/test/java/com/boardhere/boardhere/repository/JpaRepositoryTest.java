package com.boardhere.boardhere.repository;


import com.boardhere.boardhere.config.JpaConfig;
import com.boardhere.boardhere.domain.Article;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

//@DataJpaTest 실패로 인해 다른 @SpringBootTest 사용
@SpringBootTest
@DisplayName("JPA 연결 테스트")
@Import(JpaConfig.class)
class JpaRepositoryTest {

    private final ArticleRepository articleRepository;
    private final ArticleCommentRepository articleCommentRepository;
    public JpaRepositoryTest(
            @Autowired ArticleRepository articleRepository,
            @Autowired ArticleCommentRepository articleCommentRepository
    ) {
        this.articleRepository = articleRepository;
        this.articleCommentRepository = articleCommentRepository;
    }

    @DisplayName("select 테스트")
    @Test
    void givenTestData_whenSelecting_thenWorksFine() {
        // Given

        // When
        List<Article> articles = articleRepository.findAll();

        // Then
        assertThat(articles)
                .isNotNull()
                .hasSize(124);
    }

 @DisplayName("insert 테스트")
 @Test
 void givenTestData_whenInserting_thenWorksFine(){
        long previousCount = articleRepository.count();
        Article savedArticle = articleRepository.save(Article.of("new article", "content", "#spring"));

     assertThat(articleRepository.count()).isEqualTo(previousCount+1);

 }

    @DisplayName("update 테스트")
    @Test
    void givenTestData_whenUpdating_thenWorksFine(){
        Article article = articleRepository.findById(1L).orElseThrow();
        String updateHashtag = "ddd";
        article.setHashtag(updateHashtag);

        Article savedArticle = articleRepository.saveAndFlush(article);
        assertThat(savedArticle).hasFieldOrPropertyWithValue("hashtag",updateHashtag);

    }

    @DisplayName("delete 테스트")
    @Test
    void givenTestData_whenDeleting_thenWorksFine(){
        Article article = articleRepository.findById(1L).orElseThrow();
        long previousArticleCount = articleRepository.count();
        long previousArticleCommentCount = articleCommentRepository.count();
        int deletedCommentsSize = article.getArticleComments().size();
        articleRepository.delete(article);
        assertThat(articleRepository.count()).isEqualTo(previousArticleCount -1);
        assertThat(articleCommentRepository.count()).isEqualTo(previousArticleCommentCount- deletedCommentsSize);

    }
}