package com.hoangkhanh.personnelmanager.config;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    // @Bean(name = "localeResolver")
    // public LocaleResolver getLocaleResolver() {
    //     CookieLocaleResolver resolver = new CookieLocaleResolver();
    //     resolver.setCookieDomain("myAppLocaleCookie");
    //     resolver.setCookieMaxAge(60 * 60);
    //     return resolver;
    // }

    // @Bean(name = "messageSource")
    // public MessageSource getMessageResource() {
    //     ReloadableResourceBundleMessageSource messageResource = new ReloadableResourceBundleMessageSource();
    //     messageResource.setBasename("classpath:i18n/messages");
    //     messageResource.setDefaultEncoding("UTF-8");
    //     return messageResource;
    // }

    // @Override
    // public void addInterceptors(InterceptorRegistry registry) {
    //     LocaleChangeInterceptor localeInterceptor = new LocaleChangeInterceptor();
    //     localeInterceptor.setParamName("lang");

    //     registry.addInterceptor(localeInterceptor).addPathPatterns("/*");
    // }


        // Xác định ngôn ngữ người dùng chọn qua Cookie
    @Bean
    public LocaleResolver localeResolver() {
        CookieLocaleResolver localeResolver = new CookieLocaleResolver();
        localeResolver.setDefaultLocale(Locale.US);
        return localeResolver;
    }

    // Đọc lựa chọn ngôn ngữ người dùng muốn chuyển sang qua tham số lang
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        // Defaults to "locale" if not set
        localeChangeInterceptor.setParamName("lang");
        return localeChangeInterceptor;
    }

    // Bổ xung localeChangeInterceptor vào danh sách intercepter xử lý request gửi
    // lên
    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry) {
        interceptorRegistry.addInterceptor(localeChangeInterceptor());
    }
}
