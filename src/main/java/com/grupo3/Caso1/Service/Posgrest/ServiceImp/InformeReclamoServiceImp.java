package com.grupo3.Caso1.Service.Posgrest.ServiceImp;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.servlet.http.PushBuilder;

import com.grupo3.Caso1.Commons.GenericServiceImp;
import com.grupo3.Caso1.Dao.Posgrest.informeReclamoRepositori;
import com.grupo3.Caso1.Model.InformeReclamo;
import com.grupo3.Caso1.Service.Posgrest.InformeReclamoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class InformeReclamoServiceImp extends GenericServiceImp<InformeReclamo, Long> implements InformeReclamoService {

    @Autowired
    private informeReclamoRepositori informeRechazoRepositori;

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public CrudRepository<InformeReclamo, Long> getDao() {
        // TODO Auto-generated method stub
        return informeRechazoRepositori;
    }

    public InformeReclamo update(InformeReclamo informeReclamo, Long id) {
        if (informeRechazoRepositori.findById(id) != null) {
            informeReclamo.setIdinformeRecha(id);
            return informeRechazoRepositori.save(informeReclamo);
        } else {
            return null;
        }
    }

    public void cambiarRespuestaClientAcept(Long id) {
        informeRechazoRepositori.cambiarEstadoClienteAcep(id);
    }

    public void cambiarRespuestaClientCancel(Long id) {
        informeRechazoRepositori.cambiarEstadoClienteCancel(id);
    }

    public void sendMail(String toEmail, String body, String subject) throws MessagingException {
        ((JavaMailSenderImpl) javaMailSender).setHost("smtp.gmail.com");
        ((JavaMailSenderImpl) javaMailSender).setPort(587);
        ((JavaMailSenderImpl) javaMailSender).setUsername("comercializadora787@gmail.com");
        ((JavaMailSenderImpl) javaMailSender).setPassword("mjCPhcmmgU2Xb2w");
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("comercializadora787@gmail.com");
        mailMessage.setTo(toEmail);
        mailMessage.setText(body);
        mailMessage.setSubject(subject);
        /// PDF
        /*
         * MimeMessage message = javaMailSender.createMimeMessage();
         * MimeMessageHelper helper = new MimeMessageHelper(message, true);
         * helper.setFrom(toEmail);
         * helper.setSubject(body);
         * helper.setText(subject);
         * 
         * FileSystemResource file = new FileSystemResource(new
         * File("/home/oem/Desktop/links reuniones.text"));
         * helper.addAttachment("links reuniones.text", file);
         */
        javaMailSender.send(mailMessage);
    }
}
