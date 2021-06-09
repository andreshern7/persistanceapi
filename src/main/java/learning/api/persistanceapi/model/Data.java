package learning.api.persistanceapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * Data model for the business
 * 
 * @author Andres Hernandez (jorge.hez2005@gmai.com)
 * 
 */


@Entity
@Table(name="store")
public class Data {
	
	/**
	 * Unique id of the data that is store
	 */
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY) //EL Id se autoincrementa
	private Integer id;
	
	/**
	 *  The first field to store data 
	 */
	
	@Column(name="first_field", nullable = false, length = 30)
	private String firstField;
	
	
	/**
	 *  The second field to store data 
	 */
	
	@Column(name="second_field", nullable = false, length = 30)
	private String secondField;
	
	public Data(){}
	
	public Data(String firstField, String secondField) {
		this.firstField = firstField;
		this.secondField = secondField;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstField() {
		return firstField;
	}
	public void setFirstField(String firstField) {
		this.firstField = firstField;
	}
	public String getSecondField() {
		return secondField;
	}
	public void setSecondField(String secondField) {
		this.secondField = secondField;
	}
	
}
