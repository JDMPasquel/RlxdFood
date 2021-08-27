package co.edu.unicauca.restaurantshandlersevice.controller;

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

import co.edu.unicauca.restaurantshandlersevice.domain.entity.Restaurant;
import co.edu.unicauca.restaurantshandlersevice.domain.service.RestaurantServiceImpl;
import co.edu.unicauca.restaurantshandlersevice.dto.RestaurantRequest;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {
    
    @Autowired
    private RestaurantServiceImpl service;
    
    @PostMapping
    public ResponseEntity<?> createRestaurant(@RequestBody RestaurantRequest newRestaurant){

        if(newRestaurant.equals(null) || newRestaurant.getRestaurant().getNit() == null || newRestaurant.getRestaurant().getName().isEmpty() || newRestaurant.getRestaurant().getAddress().isEmpty() || newRestaurant.getRestaurant().getCity() == null || newRestaurant.getRestaurant().getRestOwner().isEmpty() || newRestaurant.getRestaurant().getRestAdmin().isEmpty() || newRestaurant.getRestaurant().getImgUrl().isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        Optional<Restaurant> oRestaurant = service.findBYNit(newRestaurant.getRestaurant().getNit());

        if(!oRestaurant.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(service.saveRestaurant(newRestaurant.getRestaurant()));
        }

        return ResponseEntity.status(HttpStatus.CONFLICT).body("The restaurant is already in existing");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> read(@PathVariable(value = "id") Long nit){
        if(nit == null){
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).build();
        }

        Optional<Restaurant> oRestaurant = service.findBYNit(nit);

        if(oRestaurant.isPresent()){
            return ResponseEntity.status(HttpStatus.FOUND).body(oRestaurant.get());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping
	public List<Restaurant> readAll(){
		
		List<Restaurant> allRestaurants = StreamSupport
				.stream(service.findAllRestaurants().spliterator(), false)
				.collect(Collectors.toList());
		
		return allRestaurants;
	}

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long nit, RestaurantRequest restaurantDetails){

        if(nit == null){
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).build();
        }

        /*if(restaurantDetails.getRestaurant().equals(null) || restaurantDetails.getRestaurant().getNit() == null || restaurantDetails.getRestaurant().getName().isEmpty() || restaurantDetails.getRestaurant().getAddress().isEmpty() || restaurantDetails.getRestaurant().getCity() == null || restaurantDetails.getRestaurant().getRestOwner().isEmpty() || restaurantDetails.getRestaurant().getRestAdmin().isEmpty() || restaurantDetails.getRestaurant().getImgUrl().isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }*/

        Optional<Restaurant> oRestaurant = service.findBYNit(nit);

        if(oRestaurant.isPresent()){
            oRestaurant.get().setNit(restaurantDetails.getRestaurant().getNit());
            oRestaurant.get().setName(restaurantDetails.getRestaurant().getName());
            oRestaurant.get().setAddress(restaurantDetails.getRestaurant().getAddress());
            oRestaurant.get().setCity(restaurantDetails.getRestaurant().getCity());
            oRestaurant.get().setImgUrl(restaurantDetails.getRestaurant().getImgUrl());
            oRestaurant.get().setSlogan(restaurantDetails.getRestaurant().getSlogan());
            oRestaurant.get().setRestOwner(restaurantDetails.getRestaurant().getRestOwner());
            oRestaurant.get().setRestAdmin(restaurantDetails.getRestaurant().getRestAdmin());
            service.deleteRestaurantByNit(nit);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.saveRestaurant(oRestaurant.get()));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRestaurantByNit(@PathVariable(value = "id") Long nit){
        if(nit == null){
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).build();
        }

        Optional<Restaurant> oRestaurant = service.findBYNit(nit);
        
        if(oRestaurant.isPresent()){
            service.deleteRestaurantByNit(nit);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
