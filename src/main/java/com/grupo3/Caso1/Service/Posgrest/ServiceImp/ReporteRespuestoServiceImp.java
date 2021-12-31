package com.grupo3.Caso1.Service.Posgrest.ServiceImp;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo3.Caso1.Commons.JasperReportManager;
import com.grupo3.Caso1.Enums.TipoReporteEnum;
import com.grupo3.Caso1.Model.ReporteRepuesto;
import com.grupo3.Caso1.Service.Posgrest.ReporteRepuestosService;

import net.sf.jasperreports.engine.JRException;
@Service

public class ReporteRespuestoServiceImp implements ReporteRepuestosService{
	@Autowired
	private JasperReportManager reportManager;

	@Autowired
	private DataSource dataSource;
	
	@Override
	public ReporteRepuesto obtenerReporteVentas(Map<String, Object> params)
			throws JRException, IOException, SQLException {
		String fileName = "Blank_A4_Landscape";
		ReporteRepuesto dto = new ReporteRepuesto();
		String extension = params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name()) ? ".xlsx"
				: ".pdf";
		dto.setFileName(fileName + extension);

		ByteArrayOutputStream stream = reportManager.export(fileName, params.get("tipo").toString(), params,
				dataSource.getConnection());

		byte[] bs = stream.toByteArray();
		dto.setStream(new ByteArrayInputStream(bs));
		dto.setLength(bs.length);

		return dto;
	}

}
