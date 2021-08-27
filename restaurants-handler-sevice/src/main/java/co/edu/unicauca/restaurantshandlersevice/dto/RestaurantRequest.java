package co.edu.unicauca.restaurantshandlersevice.dto;

import co.edu.unicauca.restaurantshandlersevice.domain.entity.Restaurant;

/**
 * @author Juan David Muñoz Pasquel - <jdamupasquel@unicauca.edu.co>
 * The objective of this class  is to be like a comodin. This class
 * contains a restaurant object (This is so important for obtain all
 * the attribs as a request solve - The restaurant is getting completely
 * in other case, without the DTO probably the numbers list could be
 * obtain apart)
 */
public class RestaurantRequest {

    private Restaurant restaurant;

    public RestaurantRequest() {}

    public RestaurantRequest(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        return "RestaurantRequest [restaurant=" + restaurant + "]";
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
