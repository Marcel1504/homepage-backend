package me.marcelberger.homepage.backend.controller;

import lombok.RequiredArgsConstructor;
import me.marcelberger.homepage.backend.enumeration.HpContentTypeEnum;
import me.marcelberger.homepage.backend.facade.content.HpContentFacade;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping("content")
@RequiredArgsConstructor
public class HpContentController {

    private final HpContentFacade contentFacade;

    @GetMapping(value = "{type}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getLatestContent(
            Locale locale,
            @PathVariable(value = "type") HpContentTypeEnum type) {
        return ResponseEntity.ok(contentFacade.getLatestContent(type, false, locale));
    }
}
