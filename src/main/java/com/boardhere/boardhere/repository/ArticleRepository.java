package com.boardhere.boardhere.repository;

import com.boardhere.boardhere.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

// ctrl + shift + t JAP 테스트 파일 만들기
public interface ArticleRepository extends JpaRepository<Article, Long> {
}