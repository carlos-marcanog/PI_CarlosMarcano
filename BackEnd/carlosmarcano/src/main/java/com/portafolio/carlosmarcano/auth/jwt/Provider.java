package com.portafolio.carlosmarcano.auth.jwt;

import com.portafolio.carlosmarcano.auth.model.Admin;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Provider {
    private final static Logger logger = LoggerFactory.getLogger(Provider.class);

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private int expiration;

    public String generarToken(Authentication authentication){
        Admin admin = (Admin) authentication.getPrincipal();
        return Jwts.builder().setSubject(admin.getUsername()).setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime()+expiration))
                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    public String obtenerNombreUsuarioDeToken(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validarToken(String token){
        try{
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        }
        catch (MalformedJwtException e){
            logger.error("Token Mal Generado");
        }
        catch (UnsupportedJwtException e){
            logger.error("Token No Soportado");
        }
        catch (ExpiredJwtException e){
            logger.error("Token Expirado");
        }
        catch (IllegalArgumentException e){
            logger.error("Token Vacio");
        }
        catch (SignatureException e){
            logger.error("Firma No Valida");
        }
        return false;
    }
}
