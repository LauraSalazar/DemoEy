package com.demoEy.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
@Component
public class JWTGenerator {
    public static String generateJWT(String subject, String secretKey) {
        return Jwts.builder()
                .setSubject(subject)
                .signWith(SignatureAlgorithm.HS256, secretKey) // Algoritmo de firma y clave secreta
                .compact(); // Construye el JWT
    }

    public String generateToken(String usuario, String secret) {
        String jwt = generateJWT(usuario, secret);
        System.out.println("JWT generado: " + jwt);
        return jwt;
    }
}
