package com.trevisan.hubspot.service.interfaces;

import com.trevisan.hubspot.restmessages.TokenRequest;
import com.trevisan.hubspot.restmessages.TokenResponse;

public interface TokenService {

  TokenResponse fetchToken(TokenRequest tokenRequest);
}
