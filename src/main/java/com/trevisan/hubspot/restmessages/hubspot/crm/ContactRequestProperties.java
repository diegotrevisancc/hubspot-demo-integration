package com.trevisan.hubspot.restmessages.hubspot.crm;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ContactRequestProperties(@JsonProperty("firstname") String firstName,
                                       @JsonProperty("lastname") String lastName,
                                       @JsonProperty("email") String email) {
}
