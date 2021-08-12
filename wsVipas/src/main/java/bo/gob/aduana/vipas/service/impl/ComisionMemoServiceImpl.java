package bo.gob.aduana.vipas.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bo.gob.aduana.vipas.model.Comision;
import bo.gob.aduana.vipas.model.ComisionMemo;
import bo.gob.aduana.vipas.model.Itinerario;
import bo.gob.aduana.vipas.model.ItinerarioMemo;
import bo.gob.aduana.vipas.model.SimpleResponse;
import bo.gob.aduana.vipas.repository.ComisionMemoRepository;
import bo.gob.aduana.vipas.repository.ComisionRepository;
import bo.gob.aduana.vipas.repository.ItinerarioMemoRepository;
import bo.gob.aduana.vipas.repository.ItinerarioRepository;
import bo.gob.aduana.vipas.repository.MemorandumRepository;
import bo.gob.aduana.vipas.service.ComisionMemoService;

@Service
public class ComisionMemoServiceImpl implements ComisionMemoService{
	@Autowired
    protected ComisionMemoRepository comisionMemoRepository;
	@Autowired
    protected ItinerarioMemoRepository itinerarioMemoRepository;	
	@Autowired
    protected ItinerarioRepository itinerarioRepository;
	@Autowired
    protected ComisionRepository comisionRepository;
	@Autowired
    protected MemorandumRepository memorandumRepository;
	
	
	@Transactional
	@Override
	public SimpleResponse guardarComisionMemo(ComisionMemo comisionMemo){	
		SimpleResponse simpleResponse;		
		try {	 
			ComisionMemo com= comisionMemoRepository.guardarComisionMemo(comisionMemo);			
			simpleResponse = new SimpleResponse("SUCCESS",com ,"200");			      
		}
		catch(Exception e)
		{
			 simpleResponse = new SimpleResponse("ERROR",e.getMessage().toString() ,"200");
		}
        return simpleResponse;
	}
	
	@Transactional
	@Override
	public String eliminarComisionMemo(String nroCom){	
		itinerarioMemoRepository.eliminarItinerariosMemo(nroCom);
		return comisionMemoRepository.eliminarComisionMemo(nroCom);		
	}
	
	@Transactional
	@Override
	public SimpleResponse registrarComision(ComisionMemo comisionMemo){
		SimpleResponse simpleResponse;		
		try {	 
			List<ItinerarioMemo> itinerarios = itinerarioMemoRepository.obtieneItinerarioCod(comisionMemo.getNrocom());
			if (itinerarios != null)
				if (!itinerarios.isEmpty()) {
					ComisionMemo cm = comisionMemoRepository.obtenerComisionMemo(comisionMemo.getNrocom());					
					if (cm != null) {
						Comision com = null;
						Comision aux =  new Comision(cm);
						aux.setUsuario(comisionMemo.getUsuario());
						com = comisionRepository.guardarComision(aux);					
						List<Itinerario> lis = new ArrayList<Itinerario>(); 
						for (ItinerarioMemo iti:  itinerarios) {
							Itinerario it = new Itinerario(iti);
							it.setNroCom(com.getNrocom());
							it.setUsuario(comisionMemo.getUsuario());
							lis.add(itinerarioRepository.guardarItinerario(it));
						}
						com.setItinerarios(lis);
						comisionMemoRepository.eliminarComisionMemo(comisionMemo.getNrocom());
						simpleResponse = new SimpleResponse("SUCCESS",com ,"200");
					}else {
						simpleResponse = new SimpleResponse("ERROR","No existe la comisión memorizada." ,"200");
					}					
				}					
				else
					simpleResponse = new SimpleResponse("ERROR","La comisión memorizada no tiene itinerario(s)." ,"200");
			else
				simpleResponse = new SimpleResponse("ERROR","La comisión memorizada no tiene itinerario(s)." ,"200");			
		}
		catch(Exception e)
		{
			 simpleResponse = new SimpleResponse("ERROR",e.getMessage() ,"200");
		}
        return simpleResponse;		
	}
	
	@Override
	public ComisionMemo obtenerComisionMemo(String nroCom){	
		ComisionMemo res = comisionMemoRepository.obtenerComisionMemo(nroCom);		
		List<ItinerarioMemo> lis = itinerarioMemoRepository.obtenerItinerariosMemo(nroCom);
		if (lis.isEmpty())
			lis = new ArrayList<ItinerarioMemo>(); 
		if (res != null)
			res.setItinerarios(lis);
		return res;
	}
	
	@Override
	public List<ComisionMemo> obtenerComisionesMemo(String gerencia){	
		List<ComisionMemo> res = comisionMemoRepository.obtenerComisionesMemo(gerencia);		
		if (res.isEmpty())
			res = new ArrayList<ComisionMemo>();
		return res;
	}
	
	@Override
	public SimpleResponse verificarMemorandum (String nroMemo) {	
		SimpleResponse simpleResponse;		
		try {
			Integer hay = comisionMemoRepository.verificaMemo(nroMemo);
			if (hay>0) {
				simpleResponse = new SimpleResponse("ERROR","El memorandúm " + nroMemo + " se encuentra memorizado.","200");
			}else {
				hay = comisionRepository.verificaMemo(nroMemo);
				if (hay>0) {
					simpleResponse = new SimpleResponse("ERROR","El memorandúm " + nroMemo + " se encuentra registrado.","200");
				}else {
					Comision com= memorandumRepository.verificarMemorandum(nroMemo);			
					simpleResponse = new SimpleResponse("SUCCESS",com ,"200");	
				}	
			}					      
		}
		catch(Exception e)
		{
			 simpleResponse = new SimpleResponse("ERROR",e.getMessage().toString() ,"200");
		}
        return simpleResponse;	
	}
}
