package me.marcelberger.homepage.backend.exception;

import lombok.extern.slf4j.Slf4j;
import me.marcelberger.homepage.backend.data.HpErrorData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
@Slf4j
public class HpExceptionHandler {

    @ExceptionHandler(HpException.class)
    public ResponseEntity<HpErrorData> handleHpException(HpException e) {
        log.debug(e.getMessage());
        return ResponseEntity.status(e.getCode().getHttpStatus()).body(HpErrorData.builder()
                .code(e.getCode())
                .properties(e.getProperties())
                .build());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<HpErrorData> handleCoreException(Exception e) {
        log.debug(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(HpErrorData.builder()
                .code(HpException.Code.HP9999)
                .properties(List.of(e.getMessage()))
                .build());
    }
}
