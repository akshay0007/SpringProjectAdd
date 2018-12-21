package com.myproject.example.service;

import com.myproject.example.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by stpl on 18/12/18.
 */
@Service
public class EmployeeManagerImpl<T, I> implements EmployeeManager<T, I> {
    @Autowired
    EmployeeDao employeeDao;

    @Override
    public List<T> getAllEmployee() {
        return employeeDao.getListEmployee();
    }

    @Override
    public void addList(T t) {
        employeeDao.addEmployee(t);
    }


}
