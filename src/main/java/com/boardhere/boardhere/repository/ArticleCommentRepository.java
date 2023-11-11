package com.boardhere.boardhere.repository;

import com.boardhere.boardhere.domain.Article;
import com.boardhere.boardhere.domain.ArticleComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleCommentRepository extends JpaRepository<ArticleComment, Long> {
}