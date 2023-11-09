package com.boardhere.boardhere.domain;

import java.time.LocalDateTime;

public class ArticleComment {
    private Long id;
    private Article article; // 게시글 (ID)
    private String content; // 본문
    private LocalDateTime createdAt; //해시태그
    private String createdBy;
    private LocalDateTime modifiedAt;
    private String modifiedBy;
}
