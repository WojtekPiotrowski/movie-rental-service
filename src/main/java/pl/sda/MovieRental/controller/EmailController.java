package pl.sda.MovieRental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import pl.sda.MovieRental.repository.EmailSender;

@Controller
public class EmailController {
    private final EmailSender emailSender;
    private final TemplateEngine templateEngine;

    @Autowired
    public EmailController(EmailSender emailSender,
                           TemplateEngine templateEngine) {
        this.emailSender = emailSender;
        this.templateEngine = templateEngine;
    }

    @RequestMapping("/send-mail")
    public String send() {
        Context context = new Context();
        context.setVariable("header", "Potwierdzenie złożenia zamówienia");
        context.setVariable("title", "Twoje zamówione filmy:");
        context.setVariable("description", " ");
        String body = templateEngine.process("template", context);
        emailSender.sendEmail("javastartspring@gmail.com", "Potwierdzenie złożenia zamówienia", body);
        return "index";
    }
}
