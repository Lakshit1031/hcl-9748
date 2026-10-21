package org.example.NotificationService;


import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student {
    private NotificationService notificationService;
    @Autowired
    public Student(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void notifyStudent() {
        notificationService.sendMsg("Your assessment is scheduled");
    }


    @PostConstruct
    public void init() {
        System.out.println("Object created");
    }

    @PostConstruct
    public void destory(){
        System.out.println("Object destroyed");
    }

}
