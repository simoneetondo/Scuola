package it.exprivia.Scuola.services.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import it.exprivia.Scuola.config.JwtConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class JwtService {

    private final JwtConfig jwtConfig;

    // 1. Creiamo il token
    public String generateToken(String username, String role) {
        return Jwts.builder()
                .claim("role", role) // Inseriamo il ruolo
                .subject(username)   // Inseriamo l'utente
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + jwtConfig.getExpiration()))
                .signWith(getSignInKey())
                .compact();
    }

    // 2. Leggiamo lo username dal token
    public String extractUsername(String token) {
        Claims claims = Jwts.parser()
                .verifyWith(getSignInKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();

        return claims.getSubject();
    }

    // 3. Verifichiamo se è scaduto
    public boolean isTokenExpired(String token) {
        Claims claims = Jwts.parser()
                .verifyWith(getSignInKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();

        return claims.getExpiration().before(new Date());
    }

    private SecretKey getSignInKey() {
        // Usa direttamente i bytes della stringa
        byte[] keyBytes = jwtConfig.getSecretKey().getBytes(java.nio.charset.StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String excractRole(String token) {
        Claims claims = Jwts.parser()
                .verifyWith(getSignInKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();

        return claims.get("role", String.class);
    }

}