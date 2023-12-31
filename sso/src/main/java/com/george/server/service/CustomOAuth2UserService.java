package com.george.server.service;

import com.george.server.type.AuthProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final UserService userService;

    @Override
    @Transactional(readOnly = true)
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);                            // Загружаем пользователя, как это было до
        String clientRegId = userRequest.getClientRegistration().getRegistrationId();   // Получаем наименование провайдера (google, github и т.д.)
        AuthProvider provider = AuthProvider.fingByName(clientRegId);                   // Для удобства создадим enum AuthProvider и по наименованию провайдера получим значение
        return userService.saveAndMap(oAuth2User, provider);                            // Создадим дополнительный сервис UserService, в котором опишем сохранение пользователя при его отсутствии в БД, а также маппинг на AuthorizedUser
    }
}
