package me.marcelberger.homepage.backend.service.media;

import org.springframework.core.io.FileSystemResource;

public interface HpMediaService {

    FileSystemResource getFileSystemResourceByMediaName(String mediaName);

    String getContentTypeByMediaName(String mediaName);
}
