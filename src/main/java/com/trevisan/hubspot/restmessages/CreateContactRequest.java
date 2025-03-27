package com.trevisan.hubspot.restmessages;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CreateContactRequest(
    @JsonProperty("first_name") String firstName,
    @JsonProperty("last_name") String lastName,
    @JsonProperty("email") String email
) {
}
