package com.trevisan.hubspot.service.interfaces;

import com.trevisan.hubspot.restmessages.CreateContactRequest;
import com.trevisan.hubspot.restmessages.CreateContactResponse;
import com.trevisan.hubspot.restmessages.CreateContactWebhookEvent;

public interface ContactService {
  CreateContactResponse createContact(String accessToken, CreateContactRequest request);
  void contactCreationWebhook(CreateContactWebhookEvent event);
}
