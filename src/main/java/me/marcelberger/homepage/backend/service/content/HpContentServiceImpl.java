package me.marcelberger.homepage.backend.service.content;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.marcelberger.homepage.backend.entity.HpContentEntity;
import me.marcelberger.homepage.backend.enumeration.HpContentLanguageEnum;
import me.marcelberger.homepage.backend.enumeration.HpContentTypeEnum;
import me.marcelberger.homepage.backend.exception.HpException;
import me.marcelberger.homepage.backend.repository.HpContentRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class HpContentServiceImpl implements HpContentService {

    private final HpContentRepository contentRepository;

    @Override
    public HpContentEntity getLatestContent(HpContentTypeEnum type, HpContentLanguageEnum language) {
        if (type == null) {
            log.debug("Can not get content because type is not provided");
            throw new HpException(HpException.Code.HP0002);
        }
        if (language == null) {
            log.debug("Can not get content because language is not provided");
            throw new HpException(HpException.Code.HP0003);
        }
        return contentRepository
                .findFirstByTypeAndLanguageOrderByVersionDateDesc(type, language)
                .orElseThrow(() -> {
                    log.debug("Can not find content with type {} and language {}", type.name(), language.name());
                    return new HpException(HpException.Code.HP0001, type.name(), language.name());
                });
    }
}
