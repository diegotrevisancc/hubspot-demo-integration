package com.trevisan.hubspot.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trevisan.hubspot.exception.InvalidCRMResourceException;
import com.trevisan.hubspot.restmessages.hubspot.crm.ContactRequest;
import com.trevisan.hubspot.restmessages.hubspot.crm.ContactResponse;
import com.trevisan.hubspot.service.interfaces.HubspotCrmService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class HubspotCrmServiceImpl implements HubspotCrmService {
  private final WebClient webClient;

  public HubspotCrmServiceImpl(WebClient.Builder webClientBuilder) {
    this.webClient = webClientBuilder.baseUrl("https://api.hubapi.com/crm/v3/objects/contacts").build();
  }

  @Override
  public ContactResponse createContact(ContactRequest request, String token) {
    try {
      ObjectMapper objectMapper = new ObjectMapper();
      String json = objectMapper.writeValueAsString(request);
      System.out.println("JSON do Request: " + json);
      ContactResponse response = webClient.post()
          .header("Authorization", "Bearer " + token).contentType(MediaType.APPLICATION_JSON)
          .bodyValue(json)
          .retrieve()
          .bodyToMono(ContactResponse.class)
          .block();
      return response;

    } catch (Exception exception) {
      throw new InvalidCRMResourceException("Error while creating contact!");
    }
  }
}
