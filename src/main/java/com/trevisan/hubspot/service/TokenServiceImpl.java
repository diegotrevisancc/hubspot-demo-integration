package com.trevisan.hubspot.service;

import com.trevisan.hubspot.restmessages.TokenRequest;
import com.trevisan.hubspot.restmessages.TokenResponse;
import com.trevisan.hubspot.service.interfaces.TokenService;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {
  @Override
  public TokenResponse fetchToken(TokenRequest tokenRequest) {
    return null;
  }
}
