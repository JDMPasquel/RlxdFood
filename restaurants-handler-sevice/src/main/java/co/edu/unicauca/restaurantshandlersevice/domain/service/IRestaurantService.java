package co.edu.unicauca.restaurantshandlersevice.domain.service;

import java.util.Optional;

import co.edu.unicauca.restaurantshandlersevice.domain.entity.Restaurant;
import co.edu.unicauca.restaurantshandlersevice.domain.entity.RestaurantNumber;

/**
 * @author Juan David Muñoz Pasquel - <jdamupasquel@unicauca.edu.co>
 */

public interface IRestaurantService {

    public Iterable<Restaurant> findAllRestaurants();

    public Optional<Restaurant> findBYNit(Long nit);

    public Optional<RestaurantNumber> findById(Long id);

    /**
     * The groupedColumns and orderedByColumn methods allows to do some
     * filters by an user
     * @param columnName The filter column (SQL query is executed with this
     * param based)
     * @return Iterable<Restaurant> the table's registers that where accepted
     * by the filter with all the attributes
     */

    public Iterable<Restaurant> groupedColumns(String columnName);

    public Iterable<Restaurant> orderedByColumn(String columnName);

    public Restaurant saveRestaurant(Restaurant savedRestaurant);

    /**
     * SaveNumber method going to allows to introduce a new number
     * without creating the restaurant newly
     * @param number the new number associated to an existing restaurant
     * @return an object of the type RestaurantNumber that indicates the
     * number stored
     */
    public RestaurantNumber saveNumber(RestaurantNumber number);

    public void deleteRestaurantByNit(Long nit);

    public void deleteNumberById(Long id);
}
