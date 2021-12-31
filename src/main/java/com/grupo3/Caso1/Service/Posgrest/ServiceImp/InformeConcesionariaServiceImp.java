package com.grupo3.Caso1.Service.Posgrest.ServiceImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.grupo3.Caso1.Commons.GenericServiceImp;
import com.grupo3.Caso1.Dao.Posgrest.InformeConcesionariaRepositorio;
import com.grupo3.Caso1.Model.ConcecionariaInforme;
import com.grupo3.Caso1.Model.InformeConcecionaria;
import com.grupo3.Caso1.Service.Posgrest.InformeConcesionariaService;


@Service
public class InformeConcesionariaServiceImp extends GenericServiceImp<InformeConcecionaria, Long> implements InformeConcesionariaService{

	
	@Autowired
	private InformeConcesionariaRepositorio informe;
	@Override
	public CrudRepository<InformeConcecionaria, Long> getDao() {
		// TODO Auto-generated method stub
		return informe;
	}


    public List<ConcecionariaInforme> MostarDatosTodo(Long id) {
    	List<ConcecionariaInforme> lista= new ArrayList<>();
    	ConcecionariaInforme info;
    	Double precio=informe.precio(id);
    	Double mano=informe.costo(id);
    	int ids= informe.id(id);
    	
	
	
			info = new ConcecionariaInforme();
			info.setMano_obra(mano);
			info.setPrecio(precio);
			info.setId(ids);
			lista.add(info);
		
        
        
        return lista;
    }
	


}













