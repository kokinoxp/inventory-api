package com.orporsoft.inventory.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expiration;

    private Key getSignKey() {

        return Keys.hmacShaKeyFor(secret.getBytes());

    }

    public String generateToken(String username) {

        Date now = new Date();

        Date expireDate = new Date(now.getTime() + expiration);

        return Jwts.builder()
                .subject(username)
                .issuedAt(now)
                .expiration(expireDate)
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();

    }

    public String extractUsername(String token) {

        return extractAllClaims(token)
                .getSubject();

    }

    public Date extractExpiration(String token) {

        return extractAllClaims(token)
                .getExpiration();

    }

    private Claims extractAllClaims(String token) {

        return Jwts.parser()
                .verifyWith((javax.crypto.SecretKey) getSignKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();

    }

    public boolean validateToken(String token, String username) {

        return username.equals(extractUsername(token))
                && extractExpiration(token).after(new Date());

    }

}
