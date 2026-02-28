package me.marcelberger.homepage.backend.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = HpChatConsentValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface HpChatConsent {

    String message() default "Chat consent text must exactly match the required statement";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}