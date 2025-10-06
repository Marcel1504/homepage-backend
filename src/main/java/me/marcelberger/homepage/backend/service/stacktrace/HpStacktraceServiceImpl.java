package me.marcelberger.homepage.backend.service.stacktrace;

import org.springframework.stereotype.Service;

import java.io.PrintWriter;
import java.io.StringWriter;

@Service
public class HpStacktraceServiceImpl implements HpStacktraceService {

    @Override
    public String convertToSingleLine(Throwable throwable) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        throwable.printStackTrace(pw);
        String raw = sw.toString();
        return raw.replace("\r", "\\r")
                .replace("\n", "\\n")
                .replace("\t", "\\t");
    }
}
