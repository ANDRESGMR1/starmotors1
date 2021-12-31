package com.grupo3.Caso1.Service.Postgres;

import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;

import com.grupo3.Caso1.Model.Cotizacion;

public interface CotizacionService {

    public List<Cotizacion> findAll();

    public Cotizacion save(Cotizacion cotizacion);

    public void delete(Long id);

    public Cotizacion findById(Long id);

    public String enviarEmail(Long id, String nombre, String correo) throws MessagingException;

    public String generarReporteCotizacion(Long id, String nombre);

}
