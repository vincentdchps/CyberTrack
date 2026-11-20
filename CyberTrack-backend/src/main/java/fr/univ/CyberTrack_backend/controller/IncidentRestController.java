package fr.univ.CyberTrack_backend.controller;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDate;
import fr.univ.CyberTrack_backend.service.IncidentService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import fr.univ.CyberTrack_backend.dto.IncidentDTO;
import fr.univ.CyberTrack_backend.service.IncidentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@RestController
@RequestMapping("/api/incidents")
public class IncidentRestController {

    private final IncidentService service;

public IncidentRestController(IncidentService service) {
    this.service = service ;
}

    @GetMapping
public ResponseEntity<List<IncidentDTO>> getAll() {
    return ResponseEntity.ok(service.getAll());
}

 @GetMapping("/{id}")
 public ResponseEntity<IncidentDTO> getById(@PathVariable long id){
    if(service.getById(id) !=null ){
    return ResponseEntity.ok(service.getById(id));
    }
    else 
        return ResponseEntity.notFound().build(); 
 }

 @PostMapping
 public ResponseEntity<IncidentDTO> create(@Valid @RequestBody IncidentDTO dto){
    IncidentDTO created = service.create(dto);
    return ResponseEntity.status(HttpStatus.CREATED).body(created);
 }

 @PutMapping("/{id}")
  public ResponseEntity<IncidentDTO> update(@PathVariable long id, @Valid @RequestBody IncidentDTO dto){
    IncidentDTO updated = service.update(id, dto);
    if(updated !=null){
    return ResponseEntity.ok(updated);
    }
    else return ResponseEntity.notFound().build();
 }

 @DeleteMapping("/{id}") 
  public ResponseEntity<Void> delete(@PathVariable long id){
    if(service.delete(id)){
    return ResponseEntity.noContent().build();
    }
    else return ResponseEntity.notFound().build();
 }
}


