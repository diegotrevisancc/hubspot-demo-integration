package com.trevisan.hubspot.restmessages.hubspot.crm;

public record ContactResponse(
    String id,
    ContactResponseProperties properties,
    String createdAt,
    String updatedAt,
    boolean archived
) {
}
