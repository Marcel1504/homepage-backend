package me.marcelberger.homepage.backend.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HpChatConsentValidator implements ConstraintValidator<HpChatConsent, String> {

    @Value("${homepage.assistant.consent}")
    private String consent;

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null) return false;
        return s.equals(consent);
    }
}
