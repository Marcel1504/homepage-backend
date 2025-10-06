package me.marcelberger.homepage.backend.service.media;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.marcelberger.homepage.backend.exception.HpException;
import me.marcelberger.homepage.backend.service.stacktrace.HpStacktraceService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
@Slf4j
@RequiredArgsConstructor
public class HpMediaServiceImpl implements HpMediaService {

    private final HpStacktraceService stacktraceService;
    @Value("${homepage.media.basePath}")
    private String mediaBasePath;

    @Override
    public FileSystemResource getFileSystemResourceByMediaName(String mediaName) {
        if (mediaName == null) {
            throw new HpException(HpException.Code.HP2001);
        }
        Path path = Path.of(mediaBasePath, mediaName);
        if (!Files.exists(path)) {
            log.debug("Can not get file with name {} because it does not exist", mediaName);
            throw new HpException(HpException.Code.HP2000, mediaName);
        }
        return new FileSystemResource(path.toFile());
    }

    @Override
    public String getContentTypeByMediaName(String mediaName) {
        try {
            Path path = getFileSystemResourceByMediaName(mediaName).getFile().toPath();
            String type = Files.probeContentType(path);
            if (type == null) {
                log.debug("Can not determine content type of media with name {}", mediaName);
                throw new HpException(HpException.Code.HP2002, "unknown type");
            }
            return type;
        } catch (IOException e) {
            log.debug("Can not determine content type of media with name {}: {}",
                    mediaName,
                    stacktraceService.convertToSingleLine(e));
            throw new HpException(HpException.Code.HP2002, e.getMessage());
        }
    }
}
