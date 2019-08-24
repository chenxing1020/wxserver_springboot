package com.cx.SecondhandMall.controller;

import com.cx.SecondhandMall.model.SessionValue;
import com.cx.SecondhandMall.service.SessionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

@Slf4j
@RestController
public class LoginController {

    @Autowired
    private SessionService sessionService;

    @Value("${sns.granttype}")
    String granttype;

    @Value("${sns.appid}")
    String appId;

    @Value("${sns.secret}")
    String secret;

    @GetMapping("/login")
    public ResponseEntity getSessionId(@RequestParam("code") String code) throws IOException {
        log.info("Getting session statistics");
        Call<SessionValue> call = sessionService.getSessionValue(granttype, appId, secret, code);
        Response<SessionValue> response = call.execute();
        if (response.isSuccessful()) {
            return ResponseEntity.ok(response.body());
        } else {
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(response.raw().toString());
        }
    }
}
