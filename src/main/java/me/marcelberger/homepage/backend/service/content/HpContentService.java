package me.marcelberger.homepage.backend.service.content;

import me.marcelberger.homepage.backend.entity.HpContentEntity;
import me.marcelberger.homepage.backend.enumeration.HpContentLanguageEnum;
import me.marcelberger.homepage.backend.enumeration.HpContentTypeEnum;

public interface HpContentService {
    HpContentEntity getLatestContent(HpContentTypeEnum type, HpContentLanguageEnum language);
}
