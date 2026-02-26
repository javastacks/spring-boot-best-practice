package cn.javastack.springboot.ds;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
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
    @Bean(destroyMethod = "close")
    @ConfigurationProperties("spring.druid.one")
    public DataSource dataSource1() {
        return DataSourceBuilder.create().type(DruidDataSource.class).build();
    }

    @Bean(destroyMethod = "close")
    @ConfigurationProperties("spring.druid.two")
    public DataSource dataSource2() {
        return DataSourceBuilder.create().type(DruidDataSource.class).build();
    }

}
