package me.marcelberger.homepage.backend.exception;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.marcelberger.homepage.backend.data.HpErrorData;
import me.marcelberger.homepage.backend.service.stacktrace.HpStacktraceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
@Slf4j
@RequiredArgsConstructor
public class HpExceptionHandler {

    private final HpStacktraceService stacktraceService;

    @ExceptionHandler(HpException.class)
    public ResponseEntity<HpErrorData> handleHpException(HpException e) {
        return ResponseEntity.status(e.getCode().getHttpStatus()).body(HpErrorData.builder()
                .code(e.getCode())
                .properties(e.getProperties())
                .build());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<HpErrorData> handleException(Exception e) {
        log.debug("Error occurred during request: {}", stacktraceService.convertToSingleLine(e));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(HpErrorData.builder()
                .code(HpException.Code.HP9990)
                .properties(List.of(e.getMessage()))
                .build());
    }
}
