package com.boardhere.boardhere.controller;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

@DisplayName("Data REST - API 테스트")
@Transactional //Rollback 상태로 트랜잭션
@AutoConfigureMockMvc
@SpringBootTest
public class DataRestTest {
    private final MockMvc mvc;

    public DataRestTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }

    @DisplayName("[api] 게시글 리스트 조회")
    @Test
    void givenNothing_whenRequestingArticels_thenReturnsArticlesJsonRequest() throws Exception{
        // Given

        // When & Then
        mvc.perform(get("/api/articles/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")))
                // api 호출 결과 콘설에 프린트
                .andDo(print());

    }

    @DisplayName("[api] 게시글 -> 댓글 리스트 조회")
    @Test
    void givenNothing_whenRequestingCommentsArticels_thenReturnsArticlesJsonRequest() throws Exception{
        // Given

        // When & Then
        mvc.perform(get("/api/articles/1/articleComments"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")))
                // api 호출 결과 콘설에 프린트
                .andDo(print());

    }

    @DisplayName("[api] 댓글 리스트 조회")
    @Test
    void givenNothing_whenRequestingComments_thenReturnsArticlesJsonRequest() throws Exception{
        // Given

        // When & Then
        mvc.perform(get("/api/articleComments"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")))
                // api 호출 결과 콘설에 프린트
                .andDo(print());

    }
    @DisplayName("[api] 댓글 단건 조회")
    @Test
    void givenNothing_whenRequestingComment_thenReturnsArticlesJsonRequest() throws Exception{
        // Given

        // When & Then
        mvc.perform(get("/api/articleComments/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")))
                // api 호출 결과 콘설에 프린트
                .andDo(print());

    }



}
