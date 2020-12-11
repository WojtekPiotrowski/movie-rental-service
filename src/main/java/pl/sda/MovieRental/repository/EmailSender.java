package pl.sda.MovieRental.repository;


public interface EmailSender {
    void sendEmail(String to, String subject, String content);
}
