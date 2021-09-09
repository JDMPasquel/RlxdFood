/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.rlxdfood.client.access;

import co.edu.unicauca.rlxdfood.client.domain.entity.Component;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author ASUS
 */
public interface IComponentRepository {
    
    public Iterable<Component> findAll();
	
    public Component findById(Long id);

    public List<Component> findByName(String name) throws Exception;

    public List<Component> groupByColumn(String columnName) throws Exception;

    public List<Component> orderByColumn(String columnName) throws Exception;

    public Component create(Component newCmpnt);
	
    public Component update(Long id, Component updtCmpnt);
	
    public void deleteById(Long id);
}
