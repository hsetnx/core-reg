package com.lefinance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

import java.util.Locale;

/**
 * @Author: jingyan
 * @Time: 2017/5/19 14:21
 * @Describe:
 */
@SpringBootApplication
@ComponentScan
public class Application {

    /**
     * @Author: jingyan
     * @Time: 2017/7/18 16:53
     * @Describe: 项目入口
     */
    public static void main(String[] args) {
        System.out.println("Application start...");
        SpringApplication.run(Application.class, args);
    }

    /**
     * @Author: jingyan
     * @Time: 2017/7/18 16:54
     * @Describe: CharacterEncodingFilter
     */
    @Bean
    public CharacterEncodingFilter characterEncodingFilter() {
        final CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return characterEncodingFilter;
    }

    /**
     * @Author: jingyan
     * @Time: 2017/7/18 16:54
     * @Describe: LocaleResolver - SIMPLIFIED_CHINESE
     */
    @Bean
    public LocaleResolver localeResolver(){
        CookieLocaleResolver localeResolver = new CookieLocaleResolver();
        localeResolver.setDefaultLocale(Locale.SIMPLIFIED_CHINESE);
        localeResolver.setCookieMaxAge(604800);
        localeResolver.setCookieName("Language");
        return localeResolver;
    }

    /**
     * @Author: jingyan
     * @Time: 2017/7/18 16:55
     * @Describe: messageSource
     */
    @Bean
    public MessageSource messageSource(){
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages/message");
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setCacheSeconds(3600);
        return messageSource;
    }
}
