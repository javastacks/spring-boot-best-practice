package cn.javastack.springboot.ai.mcp;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * MCP 客户端控制器
 * 微信公众号：Java技术栈
 */
@RequiredArgsConstructor
@RestController
@Slf4j
public class MCPClientController {

    private final ChatClient.Builder chatClientBuilder;

    private final ToolCallbackProvider tools;

    /**
     * 打印出所有的 MCP 工具
     * 微信公众号：Java技术栈
     */
    @PostConstruct
    public void init() {
        ToolCallback[] toolCallbacks = tools.getToolCallbacks();
        for (ToolCallback toolCallback : toolCallbacks) {
            log.debug("MCP Tool: {}", toolCallback.getToolDefinition().name());
        }
    }

    /**
     * 网络搜索
     * 微信公众号：Java技术栈
     */
    @GetMapping("/mcp/brave/search")
    public String search(String input) {
        var chatClient = chatClientBuilder
                .defaultToolNames("spring_ai_mcp_client_brave_search_brave_web_search")
                .build();
        return chatClient.prompt(input).call().content();
    }

}
