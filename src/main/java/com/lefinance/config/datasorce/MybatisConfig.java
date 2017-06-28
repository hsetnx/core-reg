package com.lefinance.config.datasorce;

import com.lefinance.ApplicationProperties;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: jingyan
 * @Time: 2017/6/6 15:41
 * @Describe:
 */
@Configuration
public class MybatisConfig {

    private static final String BASE_PACKAGE = ApplicationProperties.getString("mybatis.base-package");

    @Bean(name = "mapperScannerConfigurer")
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage(BASE_PACKAGE);
        return mapperScannerConfigurer;
    }
}
