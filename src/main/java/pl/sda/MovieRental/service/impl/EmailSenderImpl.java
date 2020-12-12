package pl.sda.MovieRental.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import pl.sda.MovieRental.repository.EmailSender;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


@Service
public class EmailSenderImpl implements EmailSender{
    @Autowired
    private JavaMailSender javaMailSender;
    @Override
    public void sendEmail(String to, String title, String content) {
        MimeMessage mail = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo(to);
            helper.setReplyTo("javastartspring@gmail.com");
            helper.setFrom("javastartspring@gmail.com");
            helper.setSubject(title);
            helper.setText(content, true);
        } catch (MessagingException exception) {
            exception.printStackTrace();
        }
        javaMailSender.send(mail);
    }
}
