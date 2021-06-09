package learning.api.persistanceapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import learning.api.persistanceapi.model.Data;
import learning.api.persistanceapi.service.StoreService;

/**
 * 
 * Controller to manage the HTTP request to manage data
 * 
 * @author Andres Hernandez (jorge.hez2005@gmai.com)
 * 
 */


@RestController
@RequestMapping("/storage-api")
@CrossOrigin("*")  //permite cualquier dominio (udl) para que haga peticiones a la API
public class Controller {
	

	private StoreService storageService;
	
	@Autowired
	public Controller(StoreService storageService) {
		this.storageService = storageService;
	}
	
	/**
	 * Creates a Database register with the request body 
	 * 
	 * @param toStore the atributes to create a {@link Data} object  
	 * @return {@link Data} with the body atributes
	 * 
	 */
	@PostMapping
	public ResponseEntity<Data> storeData(@RequestBody Data toStore) {
				
		return(ResponseEntity.ok(storageService.saveData(toStore)));			
	}
	
	
	/**
	 * 
	 * Gets a list with all previus insertions of {@link Data}  
	 * 
	 * @return List of {@Data}
	 */
	@GetMapping()
	public ResponseEntity<List<Data>> getData(){
			
		return(ResponseEntity.ok(storageService.getData()));
	}
	
	/**
	 * 
	 * Gets a {@link Data} by its unique identifier
	 * 
	 * @param id 
	 * @return {@link Data}
	 */
	
	@GetMapping("{id}")
	public ResponseEntity<Data> dataById(@PathVariable("id") Integer id) {
		
		return(ResponseEntity.ok(storageService.getDataById(id)));
	}
	
	
	/**
	 * 
	 * Updates {@link Data} with the @RequesBody
	 * 
	 * @param id Unique identifier of {@link Data}
	 * @param toUpdate Json with the atributes to modify
	 * @return {@link Data} with updates
	 */

	@PutMapping("{id}")
	public ResponseEntity<Data> updateById(@PathVariable("id") Integer id, @RequestBody Data toUpdate){
		
		return(ResponseEntity.ok(storageService.updateDataById(toUpdate, id)));
	}
	
	
	/**
	 * 
	 * Delete {@link Data} by its Unique identifier
	 * 
	 * @param id
	 * @return {@link Data} deleted
	 */
	@DeleteMapping("{id}")
	public ResponseEntity<Data> deleteById(@PathVariable("id") Integer id){
		
		return(ResponseEntity.ok(storageService.deleteDataById(id)));
	}

}
