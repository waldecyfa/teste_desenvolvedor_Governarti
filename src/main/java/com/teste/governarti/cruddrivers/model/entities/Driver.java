package com.teste.governarti.cruddrivers.model.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_driver")
public class Driver implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String nationality;
    
    private Instant birthDate;
   


    public Driver() {
    }

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant createdAt;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant updatedAt;


    public Driver(Long id, String name, String nationality, Instant birtDate) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
        this.birthDate = birtDate;
       
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

  

    public Instant getBirtDate() {
        return birthDate;
    }

    public void setBirtDate(Instant birtDate) {
        this.birthDate = birtDate;
    }

  


    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver client = (Driver) o;
        return Objects.equals(id, client.id) && Objects.equals(nationality, client.nationality);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nationality);
    }


    @Override
    public String toString() {
        return "Client{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", nationality='" + nationality + '\'' +
            ", birtDate=" + birthDate +
           
            '}';
    }

    @PrePersist
    public void prePersist() {
        createdAt = Instant.now();
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = Instant.now();
    }

	public String getNationality1() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getdriverId() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getwins() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setwins(Integer wins) {
		// TODO Auto-generated method stub
		
	}



}
