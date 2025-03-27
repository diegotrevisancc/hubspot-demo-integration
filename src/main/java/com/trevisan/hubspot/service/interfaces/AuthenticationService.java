package com.trevisan.hubspot.service.interfaces;

import com.trevisan.hubspot.restmessages.TokenResponse;

public interface AuthenticationService {
    String getAuthenticationUrl();

    TokenResponse oAuthCallback(String code);
}
