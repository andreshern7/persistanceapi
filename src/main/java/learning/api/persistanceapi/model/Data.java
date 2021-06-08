package learning.api.persistanceapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="store")
public class Data {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY) //EL Id se autoincrementa
	private Integer id;
	
	@Column(name="first_field", nullable = false, length = 30)
	private String firstField;
	
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
