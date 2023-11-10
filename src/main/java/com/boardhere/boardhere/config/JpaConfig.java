package com.boardhere.boardhere.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@EnableJpaAuditing
@Configuration
public class JpaConfig {
    // JPA 오디팅을 할 때 마다 uno가 default 이름으로 들어가게 된다.
    @Bean
    public AuditorAware<String> auditorAware(){
        return () -> Optional.of("uno"); //TODO: 스프링 시큐리티로 인증 기능을 붙이게 될 때, 수정.
    }
}
