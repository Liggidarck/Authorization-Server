package com.george.server.mapper;

import com.george.server.dao.entity.UserEntity;
import com.george.server.dto.AuthorizedUser;
import com.george.server.type.AuthProvider;
import lombok.experimental.UtilityClass;


import java.util.Collections;

@UtilityClass
public class AuthorizedUserMapper {
    public AuthorizedUser map(UserEntity entity, AuthProvider provider) {
        return AuthorizedUser.builder(entity.getEmail(), entity.getPasswordHash(), Collections.emptyList())
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .secondName(entity.getSecondName())
                .middleName(entity.getMiddleName())
                .birthday(entity.getBirthday())
                .avatarUrl(entity.getAvatarUrl())
                .build();
    }
}
