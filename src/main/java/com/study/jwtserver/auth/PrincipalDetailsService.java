package com.study.jwtserver.auth;

import com.study.jwtserver.modal.User;
import com.study.jwtserver.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("PrincipalDetailsService.loadUserByUsername");

        User persistUser = userRepository.findByEmail(email)
                .orElseThrow(()-> new IllegalArgumentException("회원정보 없음"));

        return new PrincipalDetails(persistUser);
    }
}
