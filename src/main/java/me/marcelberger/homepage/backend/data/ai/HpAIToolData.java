package me.marcelberger.homepage.backend.data.ai;

import lombok.Builder;
import lombok.Data;
import me.marcelberger.homepage.backend.enumeration.ai.HpAIToolTypeEnum;

@Data
@Builder
public class HpAIToolData {
    private HpAIToolTypeEnum type;
    private HpAIToolFunctionData function;

}
