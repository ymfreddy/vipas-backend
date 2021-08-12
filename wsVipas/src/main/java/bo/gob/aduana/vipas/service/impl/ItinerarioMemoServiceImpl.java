package bo.gob.aduana.vipas.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bo.gob.aduana.vipas.model.ItinerarioMemo;
import bo.gob.aduana.vipas.model.SimpleResponse;
import bo.gob.aduana.vipas.repository.ItinerarioMemoRepository;
import bo.gob.aduana.vipas.repository.entity.KeyVipItinerario;
import bo.gob.aduana.vipas.service.ItinerarioMemoService;

@Service
public class ItinerarioMemoServiceImpl implements ItinerarioMemoService{
	@Autowired
    protected ItinerarioMemoRepository itinerarioMemoRepository;
		
	@Override
	public SimpleResponse guardarItinerarioMemo(ItinerarioMemo itinerarioMemo){
		SimpleResponse simpleResponse;		
		try {	 
			ItinerarioMemo iti= itinerarioMemoRepository.guardarItinerarioMemo(itinerarioMemo);			
			simpleResponse = new SimpleResponse("SUCCESS",iti ,"200");			      
		}
		catch(Exception e)
		{
			 simpleResponse = new SimpleResponse("ERROR",e.getMessage().toString() ,"200");
		}
        return simpleResponse;
	}
	@Override
	public String eliminarItinerarioMemo(KeyVipItinerario id){		
		return itinerarioMemoRepository.eliminarItinerarioMemo(id);		
	}
	@Override
	public String eliminarItinerariosMemo(String nroCom){		
		return itinerarioMemoRepository.eliminarItinerariosMemo(nroCom);		
	}
	@Override
	public List<ItinerarioMemo> obtenerItinerariosMemo(String nroCom){		
		return itinerarioMemoRepository.obtenerItinerariosMemo(nroCom);		
	}
}
