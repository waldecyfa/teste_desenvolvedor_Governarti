package com.teste.governarti.cruddrivers.resource;

import com.teste.governarti.cruddrivers.DTO.DriverDTO;
import com.teste.governarti.cruddrivers.model.entities.Driver;
import com.teste.governarti.cruddrivers.services.DriverService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/drivers/winning")
public class DriverResource {

    @Autowired
    private DriverService driverService;


    @GetMapping(value = "/{id}")
    public ResponseEntity<DriverDTO> findByID(@PathVariable Long id) {
        DriverDTO driverDTO = driverService.findByID(id);
        return ResponseEntity.ok().body(driverDTO);
    }


    @GetMapping
    public ResponseEntity<Page<DriverDTO>> findAll(

        @RequestParam(value = "page", defaultValue = "0")Integer page,
        @RequestParam(value = "linesPerPage", defaultValue = "5") Integer linesPerPage,
        @RequestParam(value = "direction", defaultValue = "ASC") String direction,
        @RequestParam(value = "orderBy", defaultValue = "id") String orderBy

        ){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);

        Page<DriverDTO> list = driverService.findAll(pageRequest);
        return ResponseEntity.ok().body(list);
    }

    @DeleteMapping(value= "/{id}")
    public ResponseEntity<DriverDTO> deleteDriverByID(@PathVariable Long id){
        driverService.deleteDriverByID(id);

        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<DriverDTO> insertDriver(@RequestBody DriverDTO driverDTO){
        driverDTO = driverService.insert(driverDTO, driverDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(driverDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(driverDTO);

    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<DriverDTO> updateCategory(@PathVariable Long id, @RequestBody DriverDTO driverDTO){
        driverDTO = driverService.update(id, driverDTO);

        return ResponseEntity.ok().body(driverDTO);
    }




}
