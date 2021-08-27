package co.edu.unicauca.restaurantshandlersevice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.edu.unicauca.restaurantshandlersevice.domain.entity.Restaurant;

/**
 * @author Juan David Muñoz Pasquel - <jdamupasquel@unicauca.edu.co>
 */

@Repository
public interface IRestaurantDao extends JpaRepository<Restaurant , Long>{
    /**
	 * According with the first requeriments version, the service must
	 * allow group and order by a specific selected column. The
	 * groupByColumn and orderByColumn going to allows the
	 * group by and order by a selected column but as a generic way to
	 * give more flexibility to the service in case of an increment
	 * along the time
	 * 
	 */
	@Query(
		value = "SELECT rest_nit, rest_name, rest_slogan, rest_address, rest_city, rest_img, rest_admin, rest_owner FROM restaurants GROUP BY %?%",
		nativeQuery = true
	)
	public List<Restaurant> groupByColumn(String columnName);

	@Query(
		value = "SELECT * FROM restaurants ORDER BY %?%",
		nativeQuery = true
	)
	public List<Restaurant> orderBySelectedColumn(String columnName);
}
