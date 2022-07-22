package cn.javastack.springboot.web.handler;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;

@Slf4j
public class CustomConverter implements Converter<String, String> {

    @Override
    public String convert(String source) {
        if (StringUtils.isNotEmpty(source)) {
            source = source.trim();
        }
        return source;
    }

}