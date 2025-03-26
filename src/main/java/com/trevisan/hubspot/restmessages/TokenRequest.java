package com.trevisan.hubspot.restmessages;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TokenRequest(
    @JsonProperty("grant_type") String grantType,
    @JsonProperty("client_id") String clientId,
    @JsonProperty("client_secret") String clientSecret,
    @JsonProperty("redirect_url") String redirectUrl,
    String code
) {}
