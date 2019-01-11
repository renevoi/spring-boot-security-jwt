package com.renevoi.jwtboot.springbootsecurityjwt.security;

import com.renevoi.jwtboot.springbootsecurityjwt.model.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

@Component
public class JwtGenerator {
    public String generate(JwtUser jwtUser) {
    /* this is going to return the json web token -----------------*/
        Claims claims = Jwts.claims()
                .setSubject(jwtUser.getUserName());
        claims.put("userId", String.valueOf(jwtUser.getId()));
        claims.put("role", jwtUser.getRole());


               return Jwts.builder()
                        .setClaims(claims)
                        .signWith(SignatureAlgorithm.HS512, "youtube")
                        .compact();

    }
}
