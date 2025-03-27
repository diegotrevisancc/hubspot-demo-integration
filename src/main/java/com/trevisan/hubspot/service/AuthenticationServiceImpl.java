package com.trevisan.hubspot.service;

import com.trevisan.hubspot.exception.InvalidResourceException;
import com.trevisan.hubspot.restmessages.TokenRequest;
import com.trevisan.hubspot.restmessages.TokenResponse;
import com.trevisan.hubspot.service.interfaces.AuthenticationService;
import com.trevisan.hubspot.service.interfaces.TokenService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Logger;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

  @Value("${authentication.client.id}")
  private String clientId;

  @Value("${authentication.client.secret}")
  private String clientSecret;

  @Value("${authentication.client.redirect.url}")
  private String webhookUrl;

  private TokenService tokenService;

  public AuthenticationServiceImpl(TokenService tokenService) {
    this.tokenService = tokenService;
  }

  private static final Logger logger = Logger.getLogger(AuthenticationService.class.getName());

  @Override
  public String getAuthenticationUrl() {
    logger.info("Authentication URL Request Received!");
    String scopes = "crm.objects.contacts.write " +
        "crm.schemas.contacts.write oauth " +
        "crm.schemas.contacts.read crm.objects.contacts.read";

    String authUrl = "https://app.hubspot.com/oauth/authorize" +
        "?client_id=" + encode(clientId) +
        "&scope=" + encode(scopes) +
        "&redirect_uri=" + webhookUrl;

    return authUrl;
  }

  @Override
  public TokenResponse oAuthCallback(String code) {
    logger.info("oAuth Webhook Request Received!");
    if (code == null || code.isEmpty()) {
      throw new InvalidResourceException("O código do webhook de autenticação está vazio!");
    }

    TokenRequest tokenRequest = new TokenRequest("authorization_code", clientId, clientSecret, webhookUrl, code);

    return tokenService.fetchToken(tokenRequest);
  }

  //todo: tratar error com globalexceptionhandler
  private String encode(String value) {
    try {
      return URLEncoder.encode(value, "UTF-8").replace("+", "%20");
    } catch (UnsupportedEncodingException e) {
      throw new RuntimeException("Error during enconding url!");
    }
  }
}
