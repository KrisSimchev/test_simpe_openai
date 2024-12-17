package org.example;

import io.github.sashirestela.openai.SimpleOpenAI;
import io.github.sashirestela.openai.domain.chat.ChatRequest;
import io.github.sashirestela.openai.domain.chat.ChatMessage.SystemMessage;
import io.github.sashirestela.openai.domain.chat.ChatMessage.UserMessage;

public class SimpleChatExample {

    public static void main(String[] args) {
        SimpleOpenAI openAI = SimpleOpenAI.builder()
                .apiKey("OPENAI_KEY")
                .build();

        var chatRequest = ChatRequest.builder()
                .model("gpt-4o-mini")
                .message(SystemMessage.of("You are an expert in AI."))
                .message(UserMessage.of("Write a technical article about ChatGPT, no more than 100 words."))
                .temperature(0.0)
                .maxCompletionTokens(300)
                .build();

        var futureChat = openAI.chatCompletions().create(chatRequest);
        var chatResponse = futureChat.join();

        System.out.println(chatResponse.firstContent());
    }
}
