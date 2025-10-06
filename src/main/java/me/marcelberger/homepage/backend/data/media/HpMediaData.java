package me.marcelberger.homepage.backend.data.media;

import lombok.Builder;
import lombok.Data;
import org.springframework.core.io.FileSystemResource;

@Data
@Builder
public class HpMediaData {
    private FileSystemResource file;
    private String mediaType;
}
