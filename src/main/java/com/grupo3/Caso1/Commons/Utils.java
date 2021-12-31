package com.grupo3.Caso1.Commons;


import org.apache.commons.io.FileUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class Utils {

    public static String formatDate(Date fecha) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return dateFormat.format(fecha);
    }

    public static String formatDateSinHoras(Date fecha) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");
        return dateFormat.format(fecha);
    }


    public static ResponseEntity<byte[]> responsePdf(String pdfName) throws IOException {
        File file = new File(pdfName);
        byte[] contents = FileUtils.readFileToByteArray(file);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        String filename = "output.pdf";
        headers.setContentDispositionFormData(filename, filename);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        return new ResponseEntity<>(contents, headers, HttpStatus.OK);
    }
    
    @Bean
    public static Boolean enviarEmail(String to, String from, String subject, String body, List<MailAttachment> attachments) throws MessagingException {
        try {
            JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
            mailSender.setHost("smtp.gmail.com");
            mailSender.setPort(587);

            mailSender.setUsername("StarMotorsG3@gmail.com");
            mailSender.setPassword("1234567Aa.a");

            Properties props = mailSender.getJavaMailProperties();
            props.put("mail.transport.protocol", "smtp");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.debug", "true");

            MimeMessage message = mailSender.createMimeMessage();

            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(body);

            if (attachments.size() > 0) {
                for (MailAttachment attatchment : attachments) {
                    FileSystemResource file = new FileSystemResource(new File(attatchment.getPath()));
                    helper.addAttachment(attatchment.getNombre(), file);
                }
            }


            mailSender.send(message);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
}
