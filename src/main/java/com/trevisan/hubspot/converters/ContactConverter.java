package com.trevisan.hubspot.converters;

import com.trevisan.hubspot.model.EventData;
import com.trevisan.hubspot.restmessages.CreateContactRequest;
import com.trevisan.hubspot.restmessages.CreateContactResponse;
import com.trevisan.hubspot.restmessages.CreateContactWebhookEvent;
import com.trevisan.hubspot.restmessages.hubspot.crm.ContactRequestProperties;
import com.trevisan.hubspot.restmessages.hubspot.crm.ContactRequest;
import com.trevisan.hubspot.restmessages.hubspot.crm.ContactResponse;

public class ContactConverter {
  public static ContactRequest convertContactRequestToContactHubSpotRequest(CreateContactRequest userRequest) {
    ContactRequest contactRequest = new ContactRequest(
        new ContactRequestProperties(
            userRequest.firstName(),
            userRequest.lastName(),
            userRequest.email()
        )
    );

    return contactRequest;
  }

  public static CreateContactResponse convertContactResponseToCreateContactResponse(ContactResponse hubSpotResponse) {
    CreateContactResponse response = new CreateContactResponse(
        hubSpotResponse.id(),
        hubSpotResponse.properties().email(),
        hubSpotResponse.createdAt(),
        hubSpotResponse.archived()
    );

    return response;
  }

  public static EventData convertContactEventRequestToContactEventEntity(CreateContactWebhookEvent ev) {
    EventData contactEvent = new EventData(
        ev.appId(),
        ev.eventId(),
        ev.subscriptionId(),
        ev.portalId(),
        ev.occurredAt(),
        ev.subscriptionType(),
        ev.attemptNumber(),
        ev.objectId(),
        ev.changeSource(),
        ev.changeFlag()
    );

    return contactEvent;
  }
}
