package me.marcelberger.homepage.backend.facade.content;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.marcelberger.homepage.backend.entity.HpContentEntity;
import me.marcelberger.homepage.backend.enumeration.HpContentLanguageEnum;
import me.marcelberger.homepage.backend.enumeration.HpContentTypeEnum;
import me.marcelberger.homepage.backend.service.content.HpContentService;
import me.marcelberger.homepage.backend.service.jsonfilter.HpJsonFilterService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Locale;

@Service
@RequiredArgsConstructor
@Validated
public class HpContentFacadeImpl implements HpContentFacade {

    private final HpContentService contentService;

    private final HpJsonFilterService jsonFilterService;

    @Override
    @Transactional
    public String getLatestContent(HpContentTypeEnum type, boolean withDetails, Locale locale) {
        HpContentEntity contentEntity = contentService.getLatestContent(
                type,
                HpContentLanguageEnum.valueOf(locale.getLanguage().toUpperCase()));
        return withDetails
                ? contentEntity.getData()
                : jsonFilterService.removeProperty(contentEntity.getData(), "details");
    }
}
