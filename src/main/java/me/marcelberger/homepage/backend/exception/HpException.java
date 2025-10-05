package me.marcelberger.homepage.backend.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
public class HpException extends RuntimeException {
    private final Code code;
    private final List<String> properties;
    private final String message;

    public HpException(Code code) {
        this(code, new String[]{});
    }

    public HpException(Code code, String... properties) {
        this.code = code;
        this.properties = List.of(properties);
        this.message = String.format(code.getValue(), (Object[]) properties);
    }

    @Getter
    @AllArgsConstructor
    public enum Code {
        HP0001("Can not retrieve content of type '%s' and language '%s'", HttpStatus.NOT_FOUND),
        HP0002("Can not retrieve content of unknown type", HttpStatus.NOT_FOUND),
        HP0003("Can not retrieve content of unknown language", HttpStatus.NOT_FOUND),
        HP0004("Can not filter content json property '%s': %s", HttpStatus.INTERNAL_SERVER_ERROR),
        HP1000("Assistant request timeout", HttpStatus.INTERNAL_SERVER_ERROR),
        HP1001("Assistant processing error", HttpStatus.INTERNAL_SERVER_ERROR),
        HP1002("Assistant connection failure", HttpStatus.INTERNAL_SERVER_ERROR),
        HP9999("Can not handle request due to an error: %s", HttpStatus.INTERNAL_SERVER_ERROR);
        private final String value;
        private final HttpStatus httpStatus;
    }
}
