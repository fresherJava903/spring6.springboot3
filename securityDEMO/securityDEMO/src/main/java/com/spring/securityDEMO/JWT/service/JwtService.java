package com.spring.securityDEMO.JWT;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class JwtService {

    @Value("${jwt.secret-key}")
    private String secret;

    public String generateToken (String username) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, username);
    }

    public String createToken (Map<String, Object> claims, String username) {
        return Jwts
    }
}
