package learning.api.persistanceapi.service;

import java.util.List;


import learning.api.persistanceapi.model.Data;


public interface StoreService {
	
	public Data saveData(Data toStore);

	public List<Data> getData();
	
	public Data getDataById(Integer id);
	
	public Data updateDataById(Data toUpdate, Integer id);
	
	public Data deleteDataById(Integer id);
	
}
