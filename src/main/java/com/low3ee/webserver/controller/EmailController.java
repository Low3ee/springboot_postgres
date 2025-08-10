package com.low3ee.webserver.controller;

import com.low3ee.webserver.entity.Email;
import com.low3ee.webserver.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
    @Autowired private EmailService emailService;

    @PostMapping("/api/auth/sendEmail")
    public String sendEmail(@RequestBody Email email){
        return emailService.sendSimpleMail(email);
    }

    @PostMapping("/sendEmailWithAttachment")
    public String sendEmailWithAttachment(@RequestBody Email email){
        String status = emailService.sendEmailWithAttachment(email);

        return status;
    }
}
