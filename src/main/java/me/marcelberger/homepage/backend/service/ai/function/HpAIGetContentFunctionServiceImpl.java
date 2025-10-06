package me.marcelberger.homepage.backend.service.ai.function;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import me.marcelberger.homepage.backend.data.ai.function.HpAIFunctionGetContentData;
import me.marcelberger.homepage.backend.enumeration.HpContentLanguageEnum;
import me.marcelberger.homepage.backend.enumeration.HpContentTypeEnum;
import me.marcelberger.homepage.backend.enumeration.ai.HpAIFunctionEnum;
import me.marcelberger.homepage.backend.exception.HpException;
import me.marcelberger.homepage.backend.service.content.HpContentService;
import me.marcelberger.homepage.backend.service.stacktrace.HpStacktraceService;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class HpAIGetContentFunctionServiceImpl extends HpAIFunctionService<HpAIFunctionGetContentData> {

    private final HpContentService contentService;

    public HpAIGetContentFunctionServiceImpl(
            ObjectMapper objectMapper,
            HpStacktraceService stacktraceService,
            HpContentService contentService) {
        super(objectMapper, stacktraceService);
        this.contentService = contentService;
    }

    @Override
    public HpAIFunctionEnum getFunction() {
        return HpAIFunctionEnum.GET_CONTENT;
    }

    @Override
    protected Class<HpAIFunctionGetContentData> getFunctionCallDataClass() {
        return HpAIFunctionGetContentData.class;
    }

    @Override
    protected String executeByFunctionCallData(HpAIFunctionGetContentData data) {
        HpContentLanguageEnum language = HpContentLanguageEnum.valueOf(data.getLanguage().name().toUpperCase());
        return switch (data.getType()) {
            case PROFILE -> getContent(HpContentTypeEnum.PROFILE, language);
            case PROJECTS -> getContent(HpContentTypeEnum.PROJECTS, language);
            case JOBS -> getContent(HpContentTypeEnum.JOBS, language);
            case CERTIFICATIONS -> getContent(HpContentTypeEnum.CERTIFICATIONS, language);
            case EDUCATION -> getContent(HpContentTypeEnum.EDUCATION, language);
            case SOCIAL_LINKS -> getContent(HpContentTypeEnum.SOCIAL_LINKS, language);
            case UNKNOWN -> "No content is available";
        };
    }

    private String getContent(HpContentTypeEnum type, HpContentLanguageEnum language) {
        try {
            return contentService.getLatestContent(type, language).getData();
        } catch (HpException hpe) {
            return String.format("No content available, the reason is: %s", hpe.getMessage());
        }
    }
}
