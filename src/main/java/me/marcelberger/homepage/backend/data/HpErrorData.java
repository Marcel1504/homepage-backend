package me.marcelberger.homepage.backend.data;

import lombok.Builder;
import lombok.Data;
import me.marcelberger.homepage.backend.exception.HpException;

import java.util.List;

@Data
@Builder
public class HpErrorData {
    private HpException.Code code;
    private List<String> properties;
}
