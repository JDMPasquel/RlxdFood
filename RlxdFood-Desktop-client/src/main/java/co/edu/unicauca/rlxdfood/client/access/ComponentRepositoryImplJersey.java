/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.rlxdfood.client.access;

import co.edu.unicauca.rlxdfood.client.infra.NewComponentJerseyClient;

import co.edu.unicauca.rlxdfood.client.domain.entity.Component;
import java.util.List;
import javax.ws.rs.core.GenericType;

/**
 *
 * @author ASUS
 */
public class ComponentRepositoryImplJersey implements IComponentRepository{
    
    private NewComponentJerseyClient jersey;

    @Override
    public Iterable<Component> findAll() {
        GenericType<List<Component>> listResponseType = new GenericType<List<Component>>() {};
        return jersey.findAll(listResponseType);
    }

    @Override
    public Component findById(Long id) {
        return jersey.readById(Component.class, id);
    }

    @Override
    public List<Component> findByName(String name) throws Exception {
        return null;
    }

    @Override
    public List<Component> groupByColumn(String columnName) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Component> orderByColumn(String columnName) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Component create(Component newCmpnt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Component update(Long id, Component updtCmpnt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
