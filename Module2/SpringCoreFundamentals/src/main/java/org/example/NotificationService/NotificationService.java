package org.example.NotificationService;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.example.NotificationService")
public interface NotificationService {
    public void sendMsg(String msg);
}
