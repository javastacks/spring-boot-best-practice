package cn.javastack.springboot.webflux.config;

import cn.javastack.springboot.webflux.handler.CustomErrorWebExceptionHandler;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.boot.webflux.autoconfigure.error.DefaultErrorWebExceptionHandler;
import org.springframework.boot.webflux.error.ErrorAttributes;
import org.springframework.boot.webflux.error.ErrorWebExceptionHandler;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.SimpleLocaleContext;
import org.springframework.core.annotation.Order;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.util.StringUtils;
import org.springframework.web.reactive.config.ResourceHandlerRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.result.view.ViewResolver;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.i18n.LocaleContextResolver;

import java.util.Locale;

/**
 * WebFlux 配置类
 * 微信公众号：Java技术栈
 */
@Configuration
public class WebConfig implements WebFluxConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
        registry.addResourceHandler("/dist/**").addResourceLocations("classpath:/dist/");
    }

    /**
     * 自定义错误处理器，覆盖默认的 DefaultErrorWebExceptionHandler
     * @param errorAttributes
     * @param webProperties
     * @param viewResolvers
     * @param serverCodecConfigurer
     * @param applicationContext
     * @return
     */
    @Order(-1)
    @Bean
    public ErrorWebExceptionHandler errorWebExceptionHandler(ErrorAttributes errorAttributes, WebProperties webProperties,
                                                             ObjectProvider<ViewResolver> viewResolvers, ServerCodecConfigurer serverCodecConfigurer,
                                                             ApplicationContext applicationContext) {
        DefaultErrorWebExceptionHandler exceptionHandler = new CustomErrorWebExceptionHandler(errorAttributes,
                webProperties.getResources(), webProperties.getError(), applicationContext);
        exceptionHandler.setViewResolvers(viewResolvers.orderedStream().toList());
        exceptionHandler.setMessageWriters(serverCodecConfigurer.getWriters());
        exceptionHandler.setMessageReaders(serverCodecConfigurer.getReaders());
        return exceptionHandler;
    }

    /**
     * 国际化解析器，从请求参数 lang 中获取语言信息，默认为 en-US
     */
    @Bean
    public LocaleContextResolver localeContextResolver() {
        return new LocaleContextResolver() {

            @Override
            public LocaleContext resolveLocaleContext(ServerWebExchange exchange) {
                String lang = exchange.getRequest().getQueryParams().getFirst("lang");
                if (StringUtils.hasText(lang)) {
                    return new SimpleLocaleContext(Locale.forLanguageTag(lang.replace("_", "-")));
                }
                return new SimpleLocaleContext(Locale.US);
            }

            @Override
            public void setLocaleContext(ServerWebExchange exchange, LocaleContext localeContext) {
                throw new UnsupportedOperationException("Use the lang query parameter to change locale");
            }

        };
    }

}
