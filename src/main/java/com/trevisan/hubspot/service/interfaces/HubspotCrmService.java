package com.trevisan.hubspot.service.interfaces;

import com.trevisan.hubspot.restmessages.hubspot.crm.ContactRequest;
import com.trevisan.hubspot.restmessages.hubspot.crm.ContactResponse;

public interface HubspotCrmService {
  public ContactResponse createContact(ContactRequest request, String token);
}
