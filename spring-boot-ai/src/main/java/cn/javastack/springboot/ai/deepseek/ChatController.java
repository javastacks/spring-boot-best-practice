package cn.javastack.springboot.ai.deepseek;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.deepseek.DeepSeekChatModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * 微信公众号：Java技术栈
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class ChatController {

    private final DeepSeekChatModel chatModel;

    /**
     * 聊天接口
     * @param message
     * @return
     */
    @GetMapping("/ds/chat")
    public String generate(@RequestParam(value = "message", defaultValue = "hello") String message) {
        return chatModel.call(message);
    }

    /**
     * 流式聊天接口
     * @param message
     * @return
     */
    @GetMapping("/ds/chatStream")
    public Flux<ChatResponse> generateStream(@RequestParam(value = "message", defaultValue = "hello") String message) {
        Prompt prompt = new Prompt(new UserMessage(message));
        return this.chatModel.stream(prompt);
    }

}
