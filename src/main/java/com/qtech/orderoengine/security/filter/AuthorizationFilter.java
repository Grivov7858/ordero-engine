package com.qtech.orderoengine.security.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.qtech.orderoengine.security.util.SecurityConstants.*;

public class AuthorizationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String header = request.getHeader(HEADER);

        if (header == null || header.isEmpty() || !header.startsWith(TOKEN_PREFIX)) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = header.replace(TOKEN_PREFIX, "");

        try {
            Jws<Claims> claimsJws = Jwts.parserBuilder().setSigningKey(SECRET.getBytes()).build().parseClaimsJws(token);
//                    Jwts.parser()
//                    .setSigningKey(SECRET.getBytes())
//                    .parseClaimsJws(token);
            Claims body = claimsJws.getBody();

            String username = body.getSubject();

            var authorities = (List<Map<String, String>>) body.get(AUTHORITIES);


            Set<SimpleGrantedAuthority> simpleGrantedAuthorities =
                    authorities.stream()
                            .map(m -> new SimpleGrantedAuthority(m.get(AUTHORITY)))
                            .collect(Collectors.toSet());

            Authentication authentication =
                    new UsernamePasswordAuthenticationToken
                            (username, "", simpleGrantedAuthorities);

            SecurityContextHolder.getContext().setAuthentication(authentication);


        } catch (JwtException e) {
            throw new IllegalStateException(String.format("Token %s is invalid!", token));
        }
        filterChain.doFilter(request, response);
    }
}

