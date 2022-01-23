package com.example.demo.controller;

import com.example.demo.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class MailController {

    @Autowired
    EmailService emailService;


    @RequestMapping(value = "/simple-email/{user-email}", method = RequestMethod.GET)
    public ResponseEntity sendSimpleEmail(@PathVariable("user-email") String email) {

        try {
            emailService.sendSimpleMessage(email, "Welcome", "This is a welcome email");
        } catch (MailException mailException) {
            log.error("Error while sending out email..{}", mailException.getMessage());
            return new ResponseEntity<>("Unable to send email", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>("Please check your email", HttpStatus.OK);
    }

    @RequestMapping(value = "/attachment-email/{user-email}", method = RequestMethod.GET)
    public ResponseEntity sendEmailAttachment(@PathVariable("user-email") String email) {

        emailService.sendMessageWithAttachment(email, "Отчёт", "Статистический отчёт о пользователях",
                "\\users_report.pdf");

        return new ResponseEntity<>("Please check your email", HttpStatus.OK);
    }
}
