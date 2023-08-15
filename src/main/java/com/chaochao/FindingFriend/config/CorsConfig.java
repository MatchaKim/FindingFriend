package com.chaochao.FindingFriend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


@Configuration
public class CorsConfig {
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        // config.setAllowCredentials(true); // 서버 응답시 json을 자바스크립트에서 처리할 수 있게 할지 설정
        config.addAllowedOrigin("*");     // 모든 아이피의 응답 허용
        config.addAllowedHeader("*");     // 모든 header 응답 허용
        config.addAllowedMethod("*");     // 모든 Method 요청 하용

        config.addExposedHeader("Authorization");
//헤터 노출


        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);

        //set 이랑 allow 차이가 뭐야
    }


}
