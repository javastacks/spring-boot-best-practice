package cn.javastack.springboot.webflux.handler;

import org.jspecify.annotations.Nullable;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.boot.webflux.autoconfigure.error.DefaultErrorWebExceptionHandler;
import org.springframework.boot.webflux.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.util.HtmlUtils;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.Map;

/**
 * 错误处理器
 * 微信公众号：Java技术栈
 */
public class CustomErrorWebExceptionHandler extends DefaultErrorWebExceptionHandler {

    public CustomErrorWebExceptionHandler(ErrorAttributes errorAttributes,
                                          WebProperties.Resources resources,
                                          ErrorProperties errorProperties,
                                          ApplicationContext applicationContext) {
        super(errorAttributes, resources, errorProperties, applicationContext);
    }

    @Override
    protected Mono<ServerResponse> renderDefaultErrorView(ServerResponse.BodyBuilder responseBody,
                                                          Map<String, @Nullable Object> error) {
        StringBuilder builder = new StringBuilder();
        Date timestamp = (Date) error.get("timestamp");
        Object message = error.get("message");
        Object trace = error.get("trace");
        Object requestId = error.get("requestId");
        builder.append("<html><body><h1>自定义错误页面</h1>")
                .append("<p>系统出错啦，去看看日志吧！！！</p>")
                .append("<div id='created'>")
                .append(timestamp)
                .append("</div>")
                .append("<div>[")
                .append(requestId)
                .append("] 出现了意外的错误 (错误类型：")
                .append(htmlEscape(error.get("error")))
                .append(", 状态码：")
                .append(htmlEscape(error.get("status")))
                .append(").</div>");
        if (message != null) {
            builder.append("<div>").append(htmlEscape(message)).append("</div>");
        }
        if (trace != null) {
            builder.append("<div style='white-space:pre-wrap;'>").append(htmlEscape(trace)).append("</div>");
        }
        builder.append("</body></html>");
        return responseBody.bodyValue(builder.toString());
    }

    private @Nullable String htmlEscape(@Nullable Object input) {
        return (input != null) ? HtmlUtils.htmlEscape(input.toString()) : null;
    }

}