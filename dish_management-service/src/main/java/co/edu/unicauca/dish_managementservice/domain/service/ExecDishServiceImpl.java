package co.edu.unicauca.dish_managementservice.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicauca.dish_managementservice.dao.IExecDishDao;
import co.edu.unicauca.dish_managementservice.domain.entity.ExecutiveDish;

@Service
public class ExecDishServiceImpl implements IExecDishService{

    @Autowired
    private IExecDishDao execDishDao;

    @Override
    public Iterable<ExecutiveDish> findAll() {
        return execDishDao.findAll();
    }

    @Override
    public Optional<ExecutiveDish> findById(Long id) {
        return execDishDao.findById(id);
    }

    @Override
    public List<ExecutiveDish> findByName(String name) throws Exception {
        return execDishDao.findByName(name);
    }

    @Override
    public List<ExecutiveDish> groupByColumn(String columnName) throws Exception {
        return execDishDao.groupByColumn(columnName);
    }

    @Override
    public List<ExecutiveDish> orderByColumn(String columnName) throws Exception {
        return execDishDao.orderBySelectedColumn(columnName);
    }

    @Override
    public ExecutiveDish save(ExecutiveDish execSavedDish) {
        return execDishDao.save(execSavedDish);
    }

    @Override
    public void deleteById(Long id) {
        execDishDao.deleteById(id);
    }    
}
