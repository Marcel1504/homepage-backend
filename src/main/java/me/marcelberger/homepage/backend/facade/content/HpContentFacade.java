package me.marcelberger.homepage.backend.facade.content;

import jakarta.validation.constraints.NotNull;
import me.marcelberger.homepage.backend.enumeration.HpContentTypeEnum;

import java.util.Locale;

public interface HpContentFacade {
    String getLatestContent(@NotNull HpContentTypeEnum type, boolean withDetails, Locale locale);
}
