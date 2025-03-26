package com.trevisan.hubspot.service.interfaces;

public interface AuthenticationService {
    String getAuthenticationUrl();

    void oAuthCallback(String code);
}
