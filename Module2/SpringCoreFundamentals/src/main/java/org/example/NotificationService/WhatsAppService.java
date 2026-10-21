package org.example.NotificationService;

import org.springframework.stereotype.Component;


public class WhatsAppService implements NotificationService {
    @Override
    public void sendMsg(String msg) {
        System.out.println("Sending WhatsApp message: " + msg);
    }
}
