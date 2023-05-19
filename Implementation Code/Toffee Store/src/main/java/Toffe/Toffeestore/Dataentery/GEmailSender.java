package Toffe.Toffeestore.Dataentery;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;
/**

 The GEmailSender class is responsible for sending email messages and generating a random 4-digit OTP.
 */
public class GEmailSender {
    /**

     Sends an email message to a specified recipient using the Gmail SMTP server.
     @param to the email address of the recipient
     @param from the email address of the sender
     @param subject the subject of the email message
     @param text the body of the email message
     @return a boolean value indicating whether the email message was successfully sent or not
     */

    public boolean sendEmail(String to, String from, String subject, String text) {
        boolean flag = false;

        //logic
        //smtp properties
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.starttls.enable", true);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.host", "smtp.gmail.com");

        String username = "ziadeliwa93@gmail.com";
        String password = "walypsoscuylqzhg";


        //session
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setFrom(new InternetAddress(from));
            message.setSubject(subject);
            message.setText(text);
            Transport.send(message);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }


        return flag;
    }
    /**

     Generates a random 4-digit OTP (One Time Password) that can be used for authentication purposes.
     @return a string containing the 4-digit OTP
     */
    public static String generateOTP() {
        // Generate a random 4-digit number
        int otp = (int) (Math.random() * 9000) + 1000;
        String otpStr = Integer.toString(otp);
        return otpStr;
    }

}
