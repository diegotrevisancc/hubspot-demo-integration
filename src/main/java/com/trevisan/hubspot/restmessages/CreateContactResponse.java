package com.trevisan.hubspot.restmessages;

public record CreateContactResponse(
    String id,
    String email,
    String creationDate,
    Boolean archived
) {
}
