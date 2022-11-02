package cn.javastack.springboot.web.config;

import cn.javastack.springboot.web.handler.CustomConverter;
import cn.javastack.springboot.web.handler.StringWithoutSpaceDeserializer;
import cn.javastack.springboot.web.servlet.InitServlet;
import cn.javastack.springboot.web.servlet.RegisterServlet;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import jakarta.servlet.ServletRegistration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Slf4j
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * Locale 默认设置为英文
     * @return
     */
    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
        sessionLocaleResolver.setDefaultLocale(Locale.US);
        return sessionLocaleResolver;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

    /**
     * 切换语言拦截器，通过 url?lang=zh_CN 形式进行切换
     * @return
     */
    private LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        return localeChangeInterceptor;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new CustomConverter());
    }

    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        SimpleModule module = new SimpleModule();
        module.addDeserializer(String.class, new StringWithoutSpaceDeserializer(String.class));
        mapper.registerModule(module);

        converter.setObjectMapper(mapper);
        return converter;
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/user/**")
                .allowedMethods("GET", "POST")
                .allowedOrigins("https://javastack.cn")
                .allowedHeaders("header1", "header2", "header3")
                .exposedHeaders("header1", "header2")
                .allowCredentials(true).maxAge(3600);
    }

    @Bean
    public ServletRegistrationBean registerServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new RegisterServlet(), "/registerServlet");
        servletRegistrationBean.addInitParameter("name", "registerServlet");
        servletRegistrationBean.addInitParameter("sex", "man");
        return servletRegistrationBean;
    }

    @Bean
    public ServletContextInitializer servletContextInitializer() {
        return (servletContext) -> {
            ServletRegistration initServlet = servletContext.addServlet("initServlet", InitServlet.class);
            initServlet.addMapping("/initServlet");
            initServlet.setInitParameter("name", "initServlet");
            initServlet.setInitParameter("sex", "man");
        };
    }

}