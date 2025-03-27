package com.trevisan.hubspot.service;

import com.trevisan.hubspot.converters.ContactConverter;
import com.trevisan.hubspot.model.EventData;
import com.trevisan.hubspot.repository.EventDataRepository;
import com.trevisan.hubspot.restmessages.CreateContactRequest;
import com.trevisan.hubspot.restmessages.CreateContactResponse;
import com.trevisan.hubspot.restmessages.CreateContactWebhookEvent;
import com.trevisan.hubspot.restmessages.hubspot.crm.ContactRequest;
import com.trevisan.hubspot.restmessages.hubspot.crm.ContactResponse;
import com.trevisan.hubspot.service.interfaces.AuthenticationService;
import com.trevisan.hubspot.service.interfaces.ContactService;
import com.trevisan.hubspot.service.interfaces.HubspotCrmService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class ContactServiceImpl implements ContactService {
  private HubspotCrmService hubSpotCrmService;
  private EventDataRepository eventDataRepository;

  private static final Logger logger = Logger.getLogger(AuthenticationService.class.getName());

  public ContactServiceImpl(HubspotCrmService service, EventDataRepository repository) {
    this.hubSpotCrmService = service;
    this.eventDataRepository = repository;
  }

  @Override
  public CreateContactResponse createContact(String accessToken, CreateContactRequest request) {
    ContactRequest contactRequest = ContactConverter.convertContactRequestToContactHubSpotRequest(request);
    ContactResponse hubSpotResponse = hubSpotCrmService.createContact(contactRequest, accessToken);

    CreateContactResponse createContactResponse = ContactConverter.convertContactResponseToCreateContactResponse(hubSpotResponse);

    return createContactResponse;
  }

  @Override
  public void contactCreationWebhook(List<CreateContactWebhookEvent> event) {
    logger.info("Contact creation webhook received!");
    event.forEach(webhookEvent -> {
      EventData eventData = ContactConverter.convertContactEventRequestToContactEventEntity(webhookEvent);
      if (eventDataRepository.findById(eventData.getEventId()).isEmpty()) {
        eventDataRepository.saveAndFlush(eventData);
      }
    });
  }
}
