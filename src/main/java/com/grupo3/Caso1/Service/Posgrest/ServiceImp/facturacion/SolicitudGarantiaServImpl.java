package com.grupo3.Caso1.Service.Posgrest.ServiceImp.facturacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.grupo3.Caso1.Commons.GenericServiceImp;
import com.grupo3.Caso1.Dao.Posgrest.facturacion.SolicitudGarantiaRepository;
import com.grupo3.Caso1.Mappers.TallerMapper;
import com.grupo3.Caso1.Model.Factura;
import com.grupo3.Caso1.Model.MisVehiculos;
import com.grupo3.Caso1.Model.SolicitudGarantia;
import com.grupo3.Caso1.Service.Posgrest.SolicitudGarantiaService;

@Service
public class SolicitudGarantiaServImpl extends GenericServiceImp<SolicitudGarantia, Long>
		implements SolicitudGarantiaService {
	@Autowired
	private SolicitudGarantiaRepository garantiaRepository;
	
	@PersistenceContext
	private EntityManager em;
	
	public List<Factura> findByDate(Date inicio, Date fin) {
		// TODO Auto-generated method stub
		
		Query query = em.createQuery("select f from Factura f where (fecha_emision)  BETWEEN :inicio AND :fin");
		query.setParameter("inicio", inicio);
		query.setParameter("fin", fin);
		
		return query.getResultList();
	}

	@Override
	public CrudRepository<SolicitudGarantia, Long> getDao() {
		// TODO Auto-generated method stub
		return garantiaRepository;
	}

	public List<SolicitudGarantia> findAllByEstado(Boolean estado) {
		List<SolicitudGarantia> solGaranrespuesta = new ArrayList<>();
		List<SolicitudGarantia> solicitudes = garantiaRepository.findAll();
		for (int i = 0; i < solicitudes.size(); i++) {
			if (solicitudes.get(i).isEstado_solicitud() == estado) {
				solGaranrespuesta.add(solicitudes.get(i));
			}
		}
		return solGaranrespuesta;
	}

	public void cambiarEstadoSolicitud(Long id) {
		garantiaRepository.cambiarEstadoReclamo(id);
	}

	public List<String> listCarsByCedula(String id) {
		return garantiaRepository.listCarsByCedula(id);
	}

}
