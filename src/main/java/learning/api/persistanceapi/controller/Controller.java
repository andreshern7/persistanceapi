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

@RestController
@RequestMapping("/storage-api")
@CrossOrigin("*")  //permite cualquier dominio (udl) para que haga peticiones a la API
public class Controller {
	

	private StoreService storageService;
	
	@Autowired
	public Controller(StoreService storageService) {
		this.storageService = storageService;
	}
	
	
	@PostMapping
	public ResponseEntity<Data> storeData(@RequestBody Data toStore) {
				
		return(ResponseEntity.ok(storageService.saveData(toStore)));			
	}
	
	
	@GetMapping()
	public ResponseEntity<List<Data>> getData(){
			
		return(ResponseEntity.ok(storageService.getData()));
	}
	
	
	@GetMapping("{id}")
	public ResponseEntity<Data> dataById(@PathVariable("id") Integer id) {
		
		return(ResponseEntity.ok(storageService.getDataById(id)));
	}
	

	@PutMapping("{id}")
	public ResponseEntity<Data> updateById(@PathVariable("id") Integer id, @RequestBody Data toUpdate){
		
		return(ResponseEntity.ok(storageService.updateDataById(toUpdate, id)));
	}
	
	
	@DeleteMapping("{id}")
	public ResponseEntity<Data> deleteById(@PathVariable("id") Integer id){
		
		return(ResponseEntity.ok(storageService.deleteDataById(id)));
	}

}
