package com.spring.securityDEMO.JWT.encoder;

import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.Md4PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Component
public class EncoderFactory {
    public PasswordEncoder get(EncoderType type) {
        return switch (type) {
            case MD4 -> new Md4PasswordEncoder();
            case BCRYPT -> new BCryptPasswordEncoder();
            case STANDARD -> new StandardPasswordEncoder();
            default -> null;
        };
    }
}
