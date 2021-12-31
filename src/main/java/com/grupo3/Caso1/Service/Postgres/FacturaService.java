package com.grupo3.Caso1.Service.Postgres;

import java.util.List;

import com.grupo3.Caso1.Model.Factura;


public interface FacturaService {
	public List<Factura> findAll();
	
	public List<Factura> findFacturaByClienteCedulaClient(String cedulaClient);

    public Factura save(Factura factura);

    public void delete(Long id);
    
    public Factura findById(Long id);

}
