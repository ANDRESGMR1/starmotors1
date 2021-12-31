package com.grupo3.Caso1.Service.Posgrest;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import com.grupo3.Caso1.Model.ReporteRepuesto;

import net.sf.jasperreports.engine.JRException;

public interface ReporteRepuestosService {
	ReporteRepuesto obtenerReporteVentas(Map<String, Object> params) throws JRException, IOException, SQLException;


}
