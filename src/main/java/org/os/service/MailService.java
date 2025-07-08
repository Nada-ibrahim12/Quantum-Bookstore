package org.os.service;

public class MailService {
    public static void sendMail(String email, String title, String fileType) {
        System.out.printf("Sending '%s' as %s to %s%n",
                title, fileType, email);
    }
}
