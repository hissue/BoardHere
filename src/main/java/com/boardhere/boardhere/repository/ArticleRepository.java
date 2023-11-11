package com.boardhere.boardhere.repository;

import com.boardhere.boardhere.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
// ctrl + shift + t JAP 테스트 파일 만들기
public interface ArticleRepository extends JpaRepository<Article, Long> {
}