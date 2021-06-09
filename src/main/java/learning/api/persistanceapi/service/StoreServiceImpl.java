package learning.api.persistanceapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import learning.api.persistanceapi.model.Data;
import learning.api.persistanceapi.persistance.Persistance;

/**
 * 
 * It store {@link Data} in a DataBase 
 * 
 * @author Andres Hernandez (jorge.hez2005@gmai.com)
 * 
 */


@Service
public class StoreServiceImpl implements StoreService{

	Persistance persistance;
	
	@Autowired
	public StoreServiceImpl(Persistance persistance) {
		this.persistance = persistance;
	
	}
	
	
	/**
	 * Inserts into Database a Data object 
	 * 
	 * @param toStore Data to store
	 * @return Store data object
	 */
	@Override
	public Data saveData(Data toStore) {
		
		return(persistance.save(toStore));
	}
	
	
	/**
	 * Gets a list of all {@link Data} inside Database
	 * 
	 * @return List of {@link Data}
	 */
	
	@Override
	public List<Data> getData() {
		
		return(persistance.findAll());
	}

	/**
	 * Gets {@link Data} by its unique id
	 * 
	 * @param id Unique id of the {@link Data}
	 * @return {@link Data} by its id
	 */
	
	@Override
	public Data getDataById(Integer id) {
		Optional<Data> result = persistance.findById(id);
		
		if(result.isPresent() ) {
			return result.get();	
		}else {
			return null;
		}
	}

	
	/**
	 * 
	 * Updates with toUpdate atributes to {@link Data} by its id
	 * 
	 * @param toUpdate atributes to modify {@link Data}  
	 * @param id Unique id to modify atributes
	 * @return {@link Data} modified
	 */
	
	@Override
	public Data updateDataById(Data toUpdate, Integer id) {
		toUpdate.setId(id);
		Data result = persistance.save(toUpdate);
		return (result);
	}

	
	/**
	 * 
	 * Delets {@link Data} by id
	 * 
	 * @param id Unique identifier of {@link Data} to delete
	 * @return {@link Data} deleted
	 */
	@Override
	public Data deleteDataById(Integer id) {
		
		Data toDeleteData = getDataById(id);
		persistance.deleteById(id);
		return toDeleteData;
	}


}
