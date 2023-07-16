package com.study.jwtserver.jwt;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 스프링 시큐리티에서 UsernamePasswordAuthenticationFilter가 있음
// login 요청해서 email, password 전송하면(post)
// UsernamePasswordAuthenticationFilter 동작함
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    // /login 요청 시 로그인 시도를 위해 실행되는 메서드
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        System.out.println("JwtAuthenticationFilter.attemptAuthentication : 로그인 시도 중");

        // 1. username, password 받아서

        // 2. 정상인지 확인 후 로그인 시도해보는 것.
        // authenticationManager로 로그인 시도를 하면 PrincipalDetailsService.loadUserByUsername이 호출된다.

        // 3.PrincipalDetails를 세션에 담고(권한 관리를 위해서)

        // 4. JWT 토큰을 만들어서 응답해주면 된다.
        return super.attemptAuthentication(request, response);
    }
}
