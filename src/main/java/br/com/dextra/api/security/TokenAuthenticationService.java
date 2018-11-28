package br.com.dextra.api.security;

import java.io.IOException;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenAuthenticationService {

    static final String SECRET = "api@dextra.com.br";
    static final String TOKEN_PREFIX = "Bearer";
    static final String HEADER_STRING = "Authorization";

    /**
     * 
     * @param response
     * @param username
     * @throws IOException
     */
    static void addAuthentication(HttpServletResponse response, String username) throws IOException {
        String JWT = Jwts.builder()
                .setSubject(username)
                .setExpiration(getDateAuthentication())
                .signWith(SignatureAlgorithm.HS256, SECRET)//Base64Url
                .compact();

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + JWT);
        response.getWriter().write("{\"success\": true ," + "\"token\" : \"" + JWT + "\" }");
        response.setContentType("application/json");
    }

    /**
     * 
     * @return
     */
    static Date getDateAuthentication() {
        Date date = new Date(System.currentTimeMillis());
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, 1);
        return c.getTime();
    }

    /**
     * 
     * @param request
     * @return
     */
    static Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING);

        if (token != null) {
            // faz parse do token
            String user = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody()
                    .getSubject();

            if (user != null) {
                return new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
            }
        }
        return null;
    }

}