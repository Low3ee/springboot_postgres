package com.low3ee.webserver.service;

import com.low3ee.webserver.entity.Email;

public interface EmailService {

    String sendSimpleMail(Email email);

    String sendEmailWithAttachment(Email email);
}
