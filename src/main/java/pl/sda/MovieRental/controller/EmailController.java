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

    @RequestMapping("/send-order-confirmation")
    public String sendOrderConfirmationMessage() {
        Context context = new Context();
        context.setVariable("header", "Potwierdzenie złożenia zamówienia");
        context.setVariable("title", "Twoje zamówione filmy:");
        context.setVariable("description", " ");
        String body = templateEngine.process("template-confirmation", context);
        emailSender.sendEmail("javastartspring@gmail.com", "Potwierdzenie złożenia zamówienia", body);
        return "index";
    }

    @RequestMapping("/send-order-delivered")
    public String sendOrderDeliveredMessage() {
        Context context = new Context();
        context.setVariable("header", "Potwierdzenie wysłania zamówienia");
        context.setVariable("title", "Twoje zamówienie zostało wysłane. Miłego oglądania");
        String body = templateEngine.process("template-order-delivered", context);
        emailSender.sendEmail("javastartspring@gmail.com", "Twoje zamówienie zostało wysłane", body);
        return "index";
    }
}
