package co.edu.unicauca.componentservice.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.componentservice.domain.entity.Component;
import co.edu.unicauca.componentservice.domain.service.ComponentServiceImpl;

@RestController
@RequestMapping("/api/components")
public class ComponentController {
	
	@Autowired
	private ComponentServiceImpl cmpntService;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Component newCmpnt) throws Exception{
		List<Component> tmpComponents = cmpntService.findByName(newCmpnt.getName());
		if(tmpComponents.isEmpty()){
			return ResponseEntity.status(HttpStatus.CREATED).body(cmpntService.create(newCmpnt));
		}
		return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body("The component is existing into the DB already");
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id") Long componentId){
		Optional<Component> oComponent = cmpntService.findById(componentId);
		
		if(!oComponent.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(oComponent);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable(value = "id") Long componentId, @RequestBody Component componentDetails){
		Optional<Component> oComponent = cmpntService.findById(componentId);
		
		if(!oComponent.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		oComponent.get().setName(componentDetails.getName());
		oComponent.get().setType(componentDetails.getType());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(cmpntService.create(oComponent.get()));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long componentId){
		
		if(!cmpntService.findById(componentId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		cmpntService.deleteById(componentId);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public List<Component> readAll(){
		
		List<Component> allComponents = StreamSupport
				.stream(cmpntService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		
		return allComponents;
	}
}
