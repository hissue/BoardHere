package com.boardhere.boardhere.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.*;

@Getter
@ToString
@Table(indexes = {
        @Index(columnList = "title"),
        @Index(columnList = "hashtag"),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy"),
})


@Entity
public class Article extends AuditingFields{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Setter @Column(nullable = false) private String title; // 제목
    @Setter @Column(nullable = false, length = 10000) private String content; // 본문


    @Setter private String hashtag; // 해시태그

    @ToString.Exclude
    @OrderBy("id") // id로 정렬
    // 오류 발생
//    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL) // aManyToOne관계 양방향의 Team에서 Member를 조회할때 영속성 컨텍스트가 종료되어 발생하는 오류
    @OneToMany(mappedBy = "article", fetch = FetchType.EAGER, cascade = CascadeType.ALL) // article table에서 온 것 명시
    private final Set<ArticleComment> articleComments = new LinkedHashSet<>();

    protected Article(){};

    private Article(String title, String content, String hashtag) {
        this.title = title;
        this.content = content;
        this.hashtag = hashtag;
    }

    public static Article of (String title, String content, String hashtag) {
        return new Article(title,content,hashtag);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article article)) return false;
        return id !=null && id.equals(article.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
