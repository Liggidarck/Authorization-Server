package com.george.server.service;

import com.george.server.dao.entity.UserEntity;
import com.george.server.dto.AuthorizedUser;
import com.george.server.type.AuthProvider;
import org.springframework.security.oauth2.core.user.OAuth2User;

public interface UserService {
    UserEntity save(OAuth2User userDto, AuthProvider provider);

    AuthorizedUser saveAndMap(OAuth2User userDto, AuthProvider provider);
}
