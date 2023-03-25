package com.teste.governarti.cruddrivers.services;

import com.teste.governarti.cruddrivers.DTO.DriverDTO;
import com.teste.governarti.cruddrivers.model.entities.Driver;
import com.teste.governarti.cruddrivers.repositories.DriverRepository;
import com.teste.governarti.cruddrivers.services.exception.DatabaseException;
import com.teste.governarti.cruddrivers.services.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    @Transactional(readOnly = true)
    public DriverDTO findByID(Long id) {

        try {
            Optional<Driver> obj = driverRepository.findById(id);
            Driver driver = obj.orElseThrow(() -> new EntityNotFoundException("Entity not found with id: " + id));
            return new DriverDTO(driver);
        } catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("id not found " + id);
        }


    }


    @Transactional(readOnly = true)
    public Page<DriverDTO> findAll(PageRequest pageRequest) {
        Page<Driver> list = driverRepository.findAll(pageRequest);

        return list.map(DriverDTO::new);
    }

    @Transactional(readOnly = false)
    public void deleteDriverByID(Long id) {
        try {
            driverRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException("Error deleting id " + id);
        } catch (DataIntegrityViolationException e){
            throw new DatabaseException("Integrity  violation trying to delete client" + id);
        }

    }

    @Transactional(readOnly = false)
    public DriverDTO insert(DriverDTO winningDTO, DriverDTO driverDTO) {
        Driver driver = new Driver();

        
		copyDTOtoEntity(driverDTO, driver);

        CrudRepository<Driver, Long> driverRepository = null;
		driver = driverRepository.save(driver);
        return new DriverDTO(driver);
    }

    @Transactional(readOnly = false)
    public DriverDTO update(Long id, DriverDTO winningDTO) {
        try {
            JpaRepository<Driver, Long> driverRepository = null;
			Driver driver = driverRepository.getOne(id);

            DriverDTO driverDTO = null;
			copyDTOtoEntity(driverDTO, driver);

            return new DriverDTO(driver);
        } catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Not found id " + winningDTO.getId());
        }

    }

    private void copyDTOtoEntity(DriverDTO driverDTO, Driver driver){
        driver.setName(driverDTO.getName());
        driver.setNationality(driverDTO.getNationality());
        driver.setBirtDate(driverDTO.getBirthDate());
       
        
    }
}
