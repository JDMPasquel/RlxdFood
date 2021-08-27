package co.edu.unicauca.restaurantshandlersevice.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicauca.restaurantshandlersevice.dao.INumbersDao;
import co.edu.unicauca.restaurantshandlersevice.dao.IRestaurantDao;
import co.edu.unicauca.restaurantshandlersevice.domain.entity.Restaurant;
import co.edu.unicauca.restaurantshandlersevice.domain.entity.RestaurantNumber;

/**
 * @author Juan David Muñoz Pasquel - <jdamupasquel@unicauca.edu.co>
 */

@Service
public class RestaurantServiceImpl implements IRestaurantService{

    @Autowired
    private IRestaurantDao restaurantDao;

    @Autowired
    private INumbersDao numbersDao;

    @Override
    public Iterable<Restaurant> findAllRestaurants() {
        return restaurantDao.findAll();
    }

    @Override
    public Optional<Restaurant> findBYNit(Long nit) {
        return restaurantDao.findById(nit);
    }

    @Override
    public Optional<RestaurantNumber> findById(Long id) {
        return numbersDao.findById(id);
    }

    @Override
    public Iterable<Restaurant> groupedColumns(String columnName) {
        return restaurantDao.groupByColumn(columnName);
    }

    @Override
    public Iterable<Restaurant> orderedByColumn(String columnName) {
        return restaurantDao.orderBySelectedColumn(columnName);
    }

    @Override
    public Restaurant saveRestaurant(Restaurant savedRestaurant) {
        return restaurantDao.save(savedRestaurant);
    }

    @Override
    public RestaurantNumber saveNumber(RestaurantNumber number) {
        return numbersDao.save(number);
    }

    @Override
    public void deleteRestaurantByNit(Long nit) {
        restaurantDao.deleteById(nit);
    }

    @Override
    public void deleteNumberById(Long id) {
        numbersDao.deleteById(id);
    }
}
