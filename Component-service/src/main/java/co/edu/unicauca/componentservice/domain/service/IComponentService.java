package co.edu.unicauca.componentservice.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import co.edu.unicauca.componentservice.domain.entity.Component;

/**
 * @author Juan David Muñoz Pasquel - <jdamupasquel@unicauca.edu.co>
 */

public interface IComponentService {
	
	/**
	 * The service implementation will use this method but changed it to a list<Component>
	 */
	public Iterable<Component> findAll();
	
	public Page<Component> findAll(Pageable pageable);
	
	/**
	 * An Optional is used with the objective of avoid the null pointer. This method will be
	 * used for the validation in another too.
	 */
	
	public Optional<Component> findById(Long id);

	/**
	 * Doc into the IComponentDao interface
	 */
	public Boolean findByName(String name) throws Exception;

	/**
	 * As an option to do some filters by a specific column. A String is used to the filter
	 * of any column will allowed
	 */
	public List<Component> groupByColumn(String columnName) throws Exception;

	public List<Component> orderByColumn(String columnName) throws Exception;

	/**
	 * In the Service used by the controller, this methods will use the validation if the
	 * elements is not found (deleteById method, for example)
	*/
	public Component create(Component newCmpnt);
	
	public Component update(Long id, Component updtCmpnt);
	
	public void deleteById(Long id);
}
