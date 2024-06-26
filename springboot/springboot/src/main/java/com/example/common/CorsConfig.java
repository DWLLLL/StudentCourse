package com.example.common;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
// 跨域配置
@Configuration
public class CorsConfig {
    @Bean
    public CorsFilter corsFilter() {// Spring 框架提供的用于处理跨域请求的过滤器
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();//建一个URL的跨域配置源
        CorsConfiguration corsConfiguration = new CorsConfiguration();//建一个CORS配置对象
        corsConfiguration.addAllowedOrigin("*"); // 允许所有来源的请求访问
        corsConfiguration.addAllowedHeader("*"); // 允许所有请求头
        corsConfiguration.addAllowedMethod("*"); // 允许所有请求方法
        source.registerCorsConfiguration("/**", corsConfiguration); //对接口配置跨域设置
        return new CorsFilter(source);//将配置好的CORS配置源source封装成CorsFilter实例并返回
    }
}
