package cn.javastack.springboot.restservices.config;

import cn.javastack.springboot.restservices.service.AccountService;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

/**
 * HTTP 服务配置类
 * 微信公众号：Java技术栈
 */
//@Configuration
public class HttpServiceConfig {

    /**
     * RestClient 适配器
     * @param restClient
     * @return
     */
    @Bean
    public RestClientAdapter restClientAdapter(RestClient restClient) {
        return RestClientAdapter.create(restClient);
    }

    /**
     * AccountService 代理对象
     * @param restClientAdapter
     * @return
     */
    @Bean
    AccountService accountService(RestClientAdapter restClientAdapter) {
        HttpServiceProxyFactory factory = HttpServiceProxyFactory
                .builderFor(restClientAdapter).build();
        return factory.createClient(AccountService.class);
    }

}
