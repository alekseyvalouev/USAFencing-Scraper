package org.alekseyvalouev;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class SendEmail {
    private String mFrom;
    private String mTo;

    private String mHost = "smtp.gmail.com";

    private String mEmail = "xxx@gmail.com";
    private String mPass = "xxx";

    public SendEmail(String from, String to) {
        mFrom = from;
        mTo = to;
    }

    public void send(String text) {
        Properties mProperties = System.getProperties();

        mProperties.setProperty("mail.smtp.auth", "true");
        mProperties.setProperty("mail.smtp.starttls.enable", "true");
        mProperties.setProperty("mail.smtp.host", mHost);
        mProperties.setProperty("mail.smtp.port", "587");

        Session session = Session.getInstance(mProperties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(mEmail, mPass);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(mFrom));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(mTo));

            message.setSubject("New Competitions");

            message.setText(text);

            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
