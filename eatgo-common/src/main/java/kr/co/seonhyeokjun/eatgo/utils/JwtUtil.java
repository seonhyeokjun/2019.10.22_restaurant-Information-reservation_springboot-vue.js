package kr.co.seonhyeokjun.eatgo.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

public class JwtUtil {

    private Key key;

    public JwtUtil(String secret) {
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
    }

    public String createToken(long userid, String name, Long restaurantId) {

        JwtBuilder bulider = Jwts.builder()
                .claim("userId", userid)
                .claim("name", name);
        if (restaurantId != null){
            bulider = bulider.claim("restaurantId", restaurantId);
        }
        return bulider
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(token)
                .getBody();
    }
}
