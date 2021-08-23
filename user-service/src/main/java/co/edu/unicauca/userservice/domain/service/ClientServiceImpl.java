package co.edu.unicauca.userservice.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicauca.userservice.dao.IUserClientDao;
import co.edu.unicauca.userservice.domain.entity.UserClient;

@Service
public class ClientServiceImpl implements IClientService{

    @Autowired
    private IUserClientDao clientDao;

    @Override
    public Iterable<UserClient> findAll() {
        return clientDao.findAll();
    }

    @Override
    public Optional<UserClient> findById(Long id) {
        return clientDao.findById(id);
    }

    @Override
    public List<UserClient> findByName(String name) {
        return clientDao.findByName(name);
    }

    @Override
    public List<UserClient> columnsGrouped(String columnName) {
        return clientDao.groupByColumn(columnName);
    }

    @Override
    public List<UserClient> columnsOrdered(String columnName) {
        return clientDao.orderBySelectedColumn(columnName);
    }

    @Override
    public UserClient save(UserClient savedClient) {
        return clientDao.save(savedClient);
    }

    @Override
    public void deleteById(Long id) {
        clientDao.deleteById(id);
    }
}
