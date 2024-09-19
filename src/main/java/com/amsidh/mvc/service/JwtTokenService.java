package com.amsidh.mvc.service;

import org.springframework.security.core.Authentication;

public interface JwtTokenService {
    String generateToken(Authentication authentication);
}
