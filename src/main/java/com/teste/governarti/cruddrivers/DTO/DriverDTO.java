package com.teste.governarti.cruddrivers.DTO;

import java.io.Serializable;
import java.time.Instant;

import com.teste.governarti.cruddrivers.model.entities.Driver;

public class DriverDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String driverId;
    private Long id;
    public String getDriverId() {
		return driverId;
	}

	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	
    public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	private String Name;
    private String nationality;
    private Instant birthDate;
   

	
    public DriverDTO() {
    }

    public DriverDTO(String driverId, Long id, String Name, String familyName, String nationality, Instant birthDate) {
        this.driverId = driverId;
    	this.id = id;
        this.Name = Name;
        this.nationality = nationality;
        this.birthDate = birthDate;
     
    }

    public DriverDTO(Driver driver){
    	
		this.driverId = driver.getdriverId();
        this.id = driver.getId();
        this.Name = driver.getName();
        this.nationality = driver.getNationality();
        this.birthDate = driver.getBirtDate();
       
      
       
    }


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   
    public String getNationality() {
        return nationality;
    }

    public void setCpf(String cpf) {
        this.nationality = nationality;
    }


    public Instant getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Instant birthDate) {
        this.birthDate = birthDate;
    }
    
   
   
}
