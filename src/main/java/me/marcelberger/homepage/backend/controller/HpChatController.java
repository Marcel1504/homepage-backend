package me.marcelberger.homepage.backend.controller;

import me.marcelberger.homepage.backend.data.chat.HpChatRequestData;
import me.marcelberger.homepage.backend.data.chat.HpChatResponseData;
import me.marcelberger.homepage.backend.facade.chat.HpChatFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("chat")
public class HpChatController {

    @Autowired
    private HpChatFacade chatFacade;

    @PostMapping
    public ResponseEntity<HpChatResponseData> createChatResponse(@RequestBody HpChatRequestData chatRequest) {
        return ResponseEntity.ok(chatFacade.createChatResponse(chatRequest));
    }
}
