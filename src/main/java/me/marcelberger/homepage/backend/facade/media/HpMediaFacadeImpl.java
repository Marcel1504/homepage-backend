package me.marcelberger.homepage.backend.facade.media;

import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import me.marcelberger.homepage.backend.data.media.HpMediaData;
import me.marcelberger.homepage.backend.service.media.HpMediaService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class HpMediaFacadeImpl implements HpMediaFacade {

    private final HpMediaService mediaService;

    @Override
    @Transactional
    public HpMediaData getByName(@NotNull String name) {
        return HpMediaData.builder()
                .file(mediaService.getFileSystemResourceByMediaName(name))
                .mediaType(mediaService.getContentTypeByMediaName(name))
                .build();
    }
}
