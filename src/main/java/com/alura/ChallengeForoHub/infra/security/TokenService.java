package com.alura.ChallengeForoHub.infra.security;

import com.alura.ChallengeForoHub.domain.usuario.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class TokenService {
    @Value("${api.security.token.secret}")
    private String secret;

    public String generarToken(Usuario usuario){
        try {
            var algoritmo = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("API Voll.med")
                    .withSubject(usuario.getLogin())
                    .withExpiresAt(fechaExpiracion())
                    .sign(algoritmo);
        } catch (JWTCreationException exception){
            throw new RuntimeException("erro al generar el token JWT", exception);
        }
    }

    private Instant fechaExpiracion() {
        return LocalDateTime.now()
                .plusHours(2)
                .toInstant(ZoneOffset.of("-05:00"));
    }

    public String getSubject(String tokenJWT){
        try {
            var algoritmo = Algorithm.HMAC256(secret);
            return JWT.require(algoritmo)
                    .withIssuer("API Voll.med")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();


        } catch (JWTVerificationException exception){
            // Imprime el error real para diagnóstico
            System.err.println("Error JWT: " + exception.getMessage());
            throw new RuntimeException("Token JWT invalido o expirado!");
        }
    }
}
