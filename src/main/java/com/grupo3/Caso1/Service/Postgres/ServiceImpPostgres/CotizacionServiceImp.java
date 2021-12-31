package com.grupo3.Caso1.Service.Postgres.ServiceImpPostgres;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo3.Caso1.Commons.MailAttachment;
import com.grupo3.Caso1.Commons.Utils;
import com.grupo3.Caso1.Dao.Posgrest.VehiculoRepository;
import com.grupo3.Caso1.Dao.Postgres.CotizacionRepository;
import com.grupo3.Caso1.Dao.Postgres.vehiculo_catalogoRepository;
import com.grupo3.Caso1.Model.Cotizacion;
import com.grupo3.Caso1.Model.Vehiculo;
import com.grupo3.Caso1.Model.vehiculo_catalogo;
import com.grupo3.Caso1.Reports.Report;
import com.grupo3.Caso1.Reports.ReporteCotizacionContext;
import com.grupo3.Caso1.Service.Posgrest.VehiculoService;
import com.grupo3.Caso1.Service.Postgres.CotizacionService;

@Service
public class CotizacionServiceImp implements CotizacionService {

	@Autowired
	private CotizacionRepository cotizacionRepository;

	@Autowired
	private vehiculo_catalogoRepository vehiculoRepository;

	@Override
	public List<Cotizacion> findAll() {
		return cotizacionRepository.findAll();
	}

	@Override
	public Cotizacion save(Cotizacion cotizacion) {
		return cotizacionRepository.save(cotizacion);
	}

	@Override
	public void delete(Long id) {
		cotizacionRepository.deleteById(id);

	}

	@Override
	public Cotizacion findById(Long id) {
		return cotizacionRepository.findById(id).orElse(null);
	}

	@Override
	public String enviarEmail(Long id, String nombre, String correo) throws MessagingException {
		// Map<String, Object> json = new HashMap<>();
		vehiculo_catalogo vehiculo = null;
		try {
			vehiculo = vehiculoRepository.findById(id).orElse(null);
			generarReporteCotizacion(id, nombre);
			System.out.println("Eoor llega aqui");
		} catch (Exception e) {

		}

		if (vehiculo != null) {
			String pdfPath = this.generarReporteCotizacion(id, nombre);
			List<MailAttachment> attachments = List.of(new MailAttachment("Cotizacion Vehiculo.pdf", pdfPath));
			String email = correo;
			Boolean enviado = Utils.enviarEmail(email, "StarMotorsG3@gmail.com", "Reporte Cotizacion Vehiculo",
					"Reporte Cotizacion Vehiculo", attachments);
			if (enviado) {
				/*
				 * json.put("email", email);
				 * json.put("status", "enviado");
				 */
				return "Todo BIen";
			}
		}
		// json.put("status", "error");

		return "Todo mal";
	}

	@Override
	public String generarReporteCotizacion(Long id, String nombre) {
		ReporteCotizacionContext context = new ReporteCotizacionContext();
		vehiculo_catalogo vehiculo = null;
		vehiculo = vehiculoRepository.findById(id).orElse(null);

		String marca = vehiculo.getDiseno().getMarca();
		context.setMarca(marca);
		String modelo = vehiculo.getDiseno().getModelo();
		context.setModelo(modelo);
		Integer year = vehiculo.getYear_vehiculo();
		context.setYear(year);
		String capacidad_carga = vehiculo.getCaracteristica().getCapacidad_carga();
		context.setCapacidad_carga(capacidad_carga);
		String direccion = vehiculo.getCaracteristica().getDireccion();
		context.setDireccion(direccion);
		Integer cilindros = vehiculo.getCaracteristica().getCilindros();
		context.setCilindros(cilindros);
		String motor = vehiculo.getCaracteristica().getMotor();
		context.setMotor(motor);
		String tecnologia = vehiculo.getCaracteristica().getMotor();
		context.setTecnologia(tecnologia);
		String precio = "Los precios de nuestros Automoviles varian desde 15.000 dolares en adelante";
		context.setPrecio(precio);
		String nombres_cliente = nombre;
		context.setNombres_cliente(nombres_cliente);

		Report<ReporteCotizacionContext> report = new Report<>("reporte_cotizacion", context);
		report.generate();

		return report.getReportOutPdfName();
	}

}
