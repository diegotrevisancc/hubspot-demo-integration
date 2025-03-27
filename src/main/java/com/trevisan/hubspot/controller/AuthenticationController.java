package com.trevisan.hubspot.controller;

import com.trevisan.hubspot.restmessages.TokenResponse;
import com.trevisan.hubspot.service.interfaces.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authentication")
public class AuthenticationController {

    private AuthenticationService service;

    public AuthenticationController(AuthenticationService service) {
        this.service = service;
    }

    @GetMapping("/install")
    public ResponseEntity<String> getAuthenticationUrl() {
        String url = service.getAuthenticationUrl();
        return ResponseEntity.ok(url);
    }

    @GetMapping("/webhook/oauth")
    public ResponseEntity<TokenResponse> oAuthCallbackHandler(@RequestParam(required = true) String code) {
        TokenResponse tokenResponse = service.oAuthCallback(code);
        return ResponseEntity.ok(tokenResponse);
    }
}
