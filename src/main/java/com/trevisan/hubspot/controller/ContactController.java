package com.trevisan.hubspot.controller;

import com.trevisan.hubspot.restmessages.CreateContactRequest;
import com.trevisan.hubspot.restmessages.CreateContactResponse;
import com.trevisan.hubspot.restmessages.CreateContactWebhookEvent;
import com.trevisan.hubspot.service.interfaces.ContactService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {

  private ContactService service;

  public ContactController(ContactService service) {
    this.service = service;
  }

  @PostMapping("/create")
  public ResponseEntity<CreateContactResponse> create(
      @RequestHeader(name = "access_token", required = true) String token,
      @RequestBody CreateContactRequest request) {
    CreateContactResponse res = service.createContact(token, request);
    // dando erro no GlobalExceptionHandler
    return ResponseEntity.status(HttpStatus.CREATED).body(res);
  }

  @PostMapping("/webhook/contact-created")
  public void createContactWebhook(@RequestBody List<CreateContactWebhookEvent> event) {
    service.contactCreationWebhook(event);

  }
}
