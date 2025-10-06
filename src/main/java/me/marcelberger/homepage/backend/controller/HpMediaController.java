package me.marcelberger.homepage.backend.controller;

import lombok.RequiredArgsConstructor;
import me.marcelberger.homepage.backend.data.media.HpMediaData;
import me.marcelberger.homepage.backend.facade.media.HpMediaFacade;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("media")
@RequiredArgsConstructor
public class HpMediaController {

    private final HpMediaFacade mediaFacade;

    @GetMapping("{name}")
    public ResponseEntity<FileSystemResource> getMedia(@PathVariable(value = "name") String name) {
        HpMediaData media = mediaFacade.getByName(name);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(media.getMediaType() != null
                ? MediaType.parseMediaType(media.getMediaType())
                : MediaType.TEXT_PLAIN);
        return new ResponseEntity<>(media.getFile(), headers, HttpStatus.OK);
    }
}
