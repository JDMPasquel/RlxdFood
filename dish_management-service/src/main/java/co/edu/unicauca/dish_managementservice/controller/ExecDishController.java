package co.edu.unicauca.dish_managementservice.controller;

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

import co.edu.unicauca.dish_managementservice.domain.entity.ExecutiveDish;
import co.edu.unicauca.dish_managementservice.domain.service.ExecDishServiceImpl;

@RestController
@RequestMapping("/api/executiveDish")
public class ExecDishController {
    
    @Autowired
    private ExecDishServiceImpl service;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ExecutiveDish newExecDish) throws Exception{
        List<ExecutiveDish> tmpFoundDishes = service.findByName(newExecDish.getName());

        if(tmpFoundDishes.isEmpty()){
            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(newExecDish));
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    @GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id") Long execDishId){
		Optional<ExecutiveDish> oExecDish = service.findById(execDishId);
		
		if(!oExecDish.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(oExecDish);
	}
    
	@GetMapping
	public List<ExecutiveDish> readAll(){
		
		List<ExecutiveDish> allExecDishes = StreamSupport
        .stream(service.findAll().spliterator(), false)
		.collect(Collectors.toList());
		
		return allExecDishes;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable(value = "id") Long execDishId, @RequestBody ExecutiveDish execDishDetails){
		Optional<ExecutiveDish> oExecDish = service.findById(execDishId);
		
		if(!oExecDish.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
        oExecDish.get().setName(execDishDetails.getName());
        oExecDish.get().setDescription(execDishDetails.getDescription());
        oExecDish.get().setUrlImg(execDishDetails.getUrlImg());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(oExecDish.get()));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long execDishId){
		
		if(!service.findById(execDishId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		service.deleteById(execDishId);
		return ResponseEntity.ok().build();
	}
}
