package me.marcelberger.homepage.backend.service.stacktrace;

public interface HpStacktraceService {
    String convertToSingleLine(Throwable throwable);
}
