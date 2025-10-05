package me.marcelberger.homepage.backend.data.ai;

import lombok.Builder;
import lombok.Data;
import me.marcelberger.homepage.backend.enumeration.ai.HpAIFunctionEnum;

@Data
@Builder
public class HpAIToolCallFunctionData {
    HpAIFunctionEnum name;
    String arguments;
}
