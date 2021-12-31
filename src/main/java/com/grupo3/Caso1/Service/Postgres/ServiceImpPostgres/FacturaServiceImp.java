package com.grupo3.Caso1.Service.Postgres.ServiceImpPostgres;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo3.Caso1.Dao.Postgres.FacturaRepository;
import com.grupo3.Caso1.Model.Factura;
import com.grupo3.Caso1.Service.Postgres.FacturaService;

@Service
public class FacturaServiceImp implements FacturaService {
	@Autowired
	private FacturaRepository facturaRepository;

	@Override
	public List<Factura> findAll() {
		return facturaRepository.findAll();
	}

	@Override
	public Factura save(Factura factura) {
		return facturaRepository.save(factura);
	}

	@Override
	public void delete(Long id) {
		facturaRepository.deleteById(id);
	}

	@Override
	public Factura findById(Long id) {
		return facturaRepository.findById(id).orElse(null);
	}

	@Override
	public List<Factura> findFacturaByClienteCedulaClient(String cedulaClient) {
		return facturaRepository.findFacturaByClienteCedulaClient(cedulaClient);
	}

}
