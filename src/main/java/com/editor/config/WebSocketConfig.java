package com.editor.config;

import com.editor.controllers.CodeEditorHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    private final CodeEditorHandler codeEditorHandler;

    public WebSocketConfig(CodeEditorHandler codeEditorHandler) {
        this.codeEditorHandler = codeEditorHandler;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(codeEditorHandler, "/collaborate")
                .setAllowedOrigins("*");  // ✅ Allow all origins
    }
}
