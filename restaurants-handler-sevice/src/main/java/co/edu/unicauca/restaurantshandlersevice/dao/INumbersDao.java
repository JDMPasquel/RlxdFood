package co.edu.unicauca.restaurantshandlersevice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.edu.unicauca.restaurantshandlersevice.domain.entity.RestaurantNumber;

@Repository
public interface INumbersDao extends JpaRepository<RestaurantNumber, Long>{
    @Query(
        value = "SELECT * FROM restaurant_numbers WHERE nmb_number LIKE %?%",
        nativeQuery = true
    )
    public List<RestaurantNumber> findByNumber(String number);
}
