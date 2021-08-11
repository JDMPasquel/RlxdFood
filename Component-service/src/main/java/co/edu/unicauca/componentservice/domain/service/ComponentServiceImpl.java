package co.edu.unicauca.componentservice.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicauca.componentservice.dao.IComponentDao;
import co.edu.unicauca.componentservice.domain.entity.Component;

/**
 * @author Juan David Muñoz Pasquel - <jdamupasquel@unicauca.edu.co>
 */
@Service
public class ComponentServiceImpl implements IComponentService{

	/**
	 * Dependences injection according with the SOLID principles. 
	 */
	@Autowired
	private IComponentDao cmpntDao; 
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Component> findAll() {
		return cmpntDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Component> findAll(Pageable pageable) {
		return cmpntDao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Component> findById(Long id) {
		return cmpntDao.findById(id);
	}

	@Override
	public Boolean findByName(String name) throws Exception {
		Long foundRegisters;
		foundRegisters = cmpntDao.findByName(name);
		if(foundRegisters > 0){
			return true;
		}
		return false;
	}
	
	@Override
	public List<Component> groupByColumn(String columnName) throws Exception {
		try {
			List<Component> componentsFiltered = cmpntDao.groupByColumn(columnName);
			return componentsFiltered;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public List<Component> orderByColumn(String columnName) throws Exception {
		try {
			List<Component> componentsOrdered = cmpntDao.orderBySelectedColumn(columnName);
			return componentsOrdered;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	@Transactional
	public Component create(Component newCmpnt) {
		return cmpntDao.save(newCmpnt);
	}

	/**
	 * Another way to implemented the update method is the usage of the copyProperties method of
	 * the BeanUtils class --> BeanUtils.copyProperties(Object source, Object target) but this
	 * way is selected because is more explicit the process. 
	 */
	@Override
	@Transactional
	public Component update(Long id, Component updtCmpnt) {
		
		Optional<Component> oComponent = this.findById(id);
		
		Component tmpComponent = oComponent.get();
		tmpComponent.setName(updtCmpnt.getName());
		tmpComponent.setType(updtCmpnt.getType());
		
		return cmpntDao.save(tmpComponent);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		cmpntDao.deleteById(id);
	}
}
