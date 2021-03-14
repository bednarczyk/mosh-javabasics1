package com.mytube;

public class EmailService implements NotificationService{
    public void sendEmail(User user) {
        System.out.println("Notifying " + user.getEmail() + "...");
        System.out.println("Done!\n");
    }

    @Override
    public void sendNotification(User user) {
        sendEmail(user);
    }
}
