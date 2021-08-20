package co.edu.unicauca.dish_managementservice.domain.service;

import java.util.List;
import java.util.Optional;

import co.edu.unicauca.dish_managementservice.domain.entity.ExecutiveDish;

public interface IExecDishService {
    /**
	 * The service implementation will use this method but changed it to a list<ExecutiveDish>
	 */
	public Iterable<ExecutiveDish> findAll();
	
	/**
	 * An Optional is used with the objective of avoid the null pointer. This method will be
	 * used for the validation in another too.
	 */
	
	public Optional<ExecutiveDish> findById(Long id);

	/**
	 * Doc into the IExecutiveDishDao interface
	 */
	public List<ExecutiveDish> findByName(String name) throws Exception;

	/**
	 * As an option to do some filters by a specific column. A String is used to the filter
	 * of any column will allowed
	 */
	public List<ExecutiveDish> groupByColumn(String columnName) throws Exception;

	public List<ExecutiveDish> orderByColumn(String columnName) throws Exception;

	/**
	 * In the Service used by the controller, this methods will use the validation if the
	 * elements is not found (deleteById method, for example)
	*/
	public ExecutiveDish save(ExecutiveDish execSavedDish);
	
	public void deleteById(Long id);
}
