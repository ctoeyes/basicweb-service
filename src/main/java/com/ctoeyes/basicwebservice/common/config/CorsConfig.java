package com.ctoeyes.basicwebservice.common.config;

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
        source.registerCorsConfiguration("/api/**", buildConfig());
        return new CorsFilter(source);
    }

    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        // 允许跨域访问的源
        corsConfiguration.addAllowedOrigin("http://localhost:80");
        corsConfiguration.addAllowedOrigin("http://localhost:3000");
        // 允许任何头
        corsConfiguration.addAllowedHeader("*");
        // 允许任何方法（"GET", "POST", "PUT", "DELETE", "HEAD"）
        corsConfiguration.addAllowedMethod("*");
        // 允许cookie
        corsConfiguration.setAllowCredentials(true);
        return corsConfiguration;
    }
}