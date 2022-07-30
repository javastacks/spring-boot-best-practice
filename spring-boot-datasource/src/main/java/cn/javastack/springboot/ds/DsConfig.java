package cn.javastack.springboot.ds;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * 微信公众号：Java技术栈
 */
@Configuration
public class DsConfig {

    @Primary
    @Bean
    @ConfigurationProperties("spring.datasource.druid.one")
    public DataSource dataSource1() {
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.druid.two")
    public DataSource dataSource2() {
        return DruidDataSourceBuilder.create().build();
    }

}
