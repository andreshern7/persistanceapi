package learning.api.persistanceapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import learning.api.persistanceapi.model.Data;
import learning.api.persistanceapi.persistance.Dao;


@Service
public class StoreServiceImpl implements StoreService{

	Dao persistance;
	
	@Autowired
	public StoreServiceImpl(Dao persistance) {
		this.persistance = persistance;
	
	}
	
	
	@Override
	public Data saveData(Data toStore) {
		
		return(persistance.save(toStore));
	}
	
		
	@Override
	public List<Data> getData() {
		
		return(persistance.findAll());
	}

	@Override
	public Data getDataById(Integer id) {
		Optional<Data> result = persistance.findById(id);
		
		if(result.isPresent() ) {
			return result.get();	
		}else {
			return null;
		}
	}

	@Override
	public Data updateDataById(Data toUpdate, Integer id) {
		toUpdate.setId(id);
		Data result = persistance.save(toUpdate);
		return (result);
	}

	@Override
	public Data deleteDataById(Integer id) {
		
		Data toDeleteData = getDataById(id);
		persistance.deleteById(id);
		return toDeleteData;
	}


}
