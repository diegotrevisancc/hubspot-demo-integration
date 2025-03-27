package com.trevisan.hubspot.service;

import com.trevisan.hubspot.converters.ContactConverter;
import com.trevisan.hubspot.restmessages.CreateContactRequest;
import com.trevisan.hubspot.restmessages.CreateContactResponse;
import com.trevisan.hubspot.restmessages.CreateContactWebhookEvent;
import com.trevisan.hubspot.restmessages.hubspot.crm.ContactRequest;
import com.trevisan.hubspot.restmessages.hubspot.crm.ContactResponse;
import com.trevisan.hubspot.service.interfaces.ContactService;
import com.trevisan.hubspot.service.interfaces.HubspotCrmService;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {
  private HubspotCrmService hubSpotCrmService;

  public ContactServiceImpl(HubspotCrmService service) {
    this.hubSpotCrmService = service;
  }

  @Override
  public CreateContactResponse createContact(String accessToken, CreateContactRequest request) {
    ContactRequest contactRequest = ContactConverter.convertContactRequestToContactHubSpotRequest(request);
    ContactResponse hubSpotResponse = hubSpotCrmService.createContact(contactRequest, accessToken);

    CreateContactResponse createContactResponse = ContactConverter.convertContactResponseToCreateContactResponse(hubSpotResponse);

    return createContactResponse;
  }

  @Override
  public void contactCreationWebhook(CreateContactWebhookEvent event) {

  }
}
