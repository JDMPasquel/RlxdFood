package co.edu.unicauca.userservice.infra;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import co.edu.unicauca.userservice.domain.entity.UserClient;
import co.edu.unicauca.userservice.domain.service.ClientServiceImpl;
import co.edu.unicauca.userservice.domain.service.IClientService;

public class ClientProxy implements IClientService{

    private ClientServiceImpl service;
    private final static Logger LOGGER = Logger.getLogger(ClientProxy.class.getName());

    @Override
    public Iterable<UserClient> findAll() {
        LOGGER.info("//------Client proxy - finding all------//");
        return service.findAll();
    }

    @Override
    public Optional<UserClient> findById(Long id) {
        LOGGER.info("//------Client proxy - finding by id------//");
        return service.findById(id);
    }

    @Override
    public List<UserClient> findByName(String name) {
        LOGGER.info("//------Client proxy - finding by name ------//");
        return service.findByName(name);
    }

    @Override
    public List<UserClient> columnsGrouped(String columnName) {
        LOGGER.info("//------Client proxy - grouping the columns ------//");
        return service.columnsGrouped(columnName);
    }

    @Override
    public List<UserClient> columnsOrdered(String columnName) {
        LOGGER.info("//------Client proxy - ordering the columns ------//");
        return service.columnsOrdered(columnName);
    }

    @Override
    public UserClient save(UserClient savedClient) {
        LOGGER.info("//------Client proxy - saving ------//");
        return service.save(savedClient);
    }

    @Override
    public void deleteById(Long id) {
        LOGGER.warning("AN USER WILL BE DELETED");
        service.deleteById(id);
    }
}
