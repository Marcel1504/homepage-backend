package me.marcelberger.homepage.backend.service.content;

import lombok.RequiredArgsConstructor;
import me.marcelberger.homepage.backend.entity.HpContentEntity;
import me.marcelberger.homepage.backend.enumeration.HpContentTypeEnum;
import me.marcelberger.homepage.backend.exception.HpException;
import me.marcelberger.homepage.backend.repository.HpContentRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HpContentServiceImpl implements HpContentService {

    private final HpContentRepository contentRepository;

    @Override
    public HpContentEntity getLatestContent(HpContentTypeEnum type, String language) {
        if (type == null) {
            throw new HpException(HpException.Code.HP0002);
        }
        if (language == null) {
            throw new HpException(HpException.Code.HP0003);
        }
        return contentRepository
                .findFirstByTypeAndLanguageOrderByVersionDateDesc(type, language)
                .orElseThrow(() -> new HpException(HpException.Code.HP0001, type.name(), language));
    }
}
