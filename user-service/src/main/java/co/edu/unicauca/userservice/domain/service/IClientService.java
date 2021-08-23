package co.edu.unicauca.userservice.domain.service;

import java.util.List;
import java.util.Optional;

import co.edu.unicauca.userservice.domain.entity.UserClient;

public interface IClientService {

    public Iterable<UserClient> findAll();

    public Optional<UserClient> findById(Long id);

    public List<UserClient> findByName(String name);

    public List<UserClient> columnsGrouped(String columnName);

    public List<UserClient> columnsOrdered(String columnName);

    public UserClient save(UserClient savedClient);

    public void deleteById(Long id);

}
