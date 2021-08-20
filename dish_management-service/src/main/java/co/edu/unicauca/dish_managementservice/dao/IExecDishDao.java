package co.edu.unicauca.dish_managementservice.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.edu.unicauca.dish_managementservice.domain.entity.ExecutiveDish;

public interface IExecDishDao extends JpaRepository<ExecutiveDish, Long>{
    /**
	 * searching by id isn't enough. What if, for example, into the Data
	 * Base I have a ExecutiveDish with Id 1 and name "Vegetables" and I
	 * want to insert a new ExecutiveDish with the same name,having
	 * automatic id assignment this will possible because, for the DB
	 * motor, I have two differente id, and for that, two diferent
	 * ExecutiveDishs, In fact, I will get into the DB
	 * the same ExecutiveDish (same name, same type but different id), this
	 * would be a referential integrity error. The findById has usage in
	 * others methods, but for create isn't enough,
	 * in order to solve it, a new method is implemented (findByName)
	 * @param name ExecutiveDish name to search it if it's into the DB or,
	 * effectly is a new ExecutiveDish.
	 * @return a List with the name of the searched ExecutiveDish (if exists)
	 */
    @Query(
        value = "SELECT * FROM executive_dish WHERE name LIKE %?%",
        nativeQuery = true
    )
    public List<ExecutiveDish> findByName(String name);

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
		value = "SELECT * FROM executive_dish GROUP BY %?%",
		nativeQuery = true
	)
	public List<ExecutiveDish> groupByColumn(String column);

	@Query(
		value = "SELECT * FROM executive_dish ORDER BY %?%",
		nativeQuery = true
	)
	public List<ExecutiveDish> orderBySelectedColumn(String column);
}
