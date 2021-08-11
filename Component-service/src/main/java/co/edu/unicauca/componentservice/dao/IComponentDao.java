package co.edu.unicauca.componentservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.edu.unicauca.componentservice.domain.entity.Component;

/**
 * @author Juan David Muñoz Pasquel - <jdamupasquel@unicauca.edu.co>
 */

/**
 * A JpaRepository is used instead of the CrudRepository because the
 * JpaRepository is more flexible and has more methods, the pageable
 * search, for example, given more flexibility into the app.
 */
@Repository
public interface IComponentDao extends JpaRepository<Component, Long>{

    /**
	 * searching by id isn't enough. What if, for example, into the Data
	 * Base I have a component with Id 1 and name "Vegetables" and I
	 * want to insert a new component with the same name,having
	 * automatic id assignment this will possible because, for the DB
	 * motor, I have two differente id, and for that, two diferent
	 * components, In fact, I will get into the DB
	 * the same component (same name, same type but different id), this
	 * would be a referential integrity error. The findById has usage in
	 * others methods, but for create isn't enough,
	 * in order to solve it, a new method is implemented (findByName)
	 * @param name Component name to search it if it's into the DB or,
	 * effectly is a new component.
	 * @return a List with the name of the searched component (if exists)
	 */
    @Query(
        value = "SELECT * FROM components WHERE name LIKE %?%",
        nativeQuery = true
    )
    public List<Component> findByName(String name);

	/**
	 * According with the first requeriments version, the service must
	 * allow group and order by a specific selected column. The
	 * groupByColumn and orderByColumn going to allows the
	 * group by and order by a selected column but as a generic form to
	 * give more flexibility to the service in case of an increment
	 * along the time
	 * 
	 */
	@Query(
		value = "SELECT * FROM components GROUP BY %?%",
		nativeQuery = true
	)
	public List<Component> groupByColumn(String column);

	@Query(
		value = "SELECT * FROM components ORDER BY %?%",
		nativeQuery = true
	)
	public List<Component> orderBySelectedColumn(String column);
}
