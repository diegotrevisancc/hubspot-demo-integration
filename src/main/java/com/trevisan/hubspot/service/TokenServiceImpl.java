package com.trevisan.hubspot.service;

import com.trevisan.hubspot.exception.InvalidResourceException;
import com.trevisan.hubspot.restmessages.TokenRequest;
import com.trevisan.hubspot.restmessages.TokenResponse;
import com.trevisan.hubspot.service.interfaces.TokenService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


@Service
public class TokenServiceImpl implements TokenService {

  private final WebClient webClient;

  public TokenServiceImpl(WebClient.Builder webClientBuilder) {
    this.webClient = webClientBuilder.baseUrl("https://api.hubapi.com123").build();
  }

  @Override
  public TokenResponse fetchToken(TokenRequest tokenRequest) {
    try {
      String requestBody = String.format(
          "grant_type=%s&code=%s&redirect_uri=%s&client_id=%s&client_secret=%s",
          tokenRequest.grantType(),
          tokenRequest.code(),
          tokenRequest.redirectUrl(),
          tokenRequest.clientId(),
          tokenRequest.clientSecret()
      );

      TokenResponse response = webClient.post()
          .uri("/oauth/v1/token")
          .contentType(MediaType.APPLICATION_FORM_URLENCODED)
          .bodyValue(requestBody)
          .retrieve()
          .bodyToMono(TokenResponse.class)
          .block();

      return response;
    } catch (Exception exception) {
      throw new InvalidResourceException("Error while fetching accesss token");
    }

  }
}
