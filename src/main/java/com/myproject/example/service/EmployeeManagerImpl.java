package com.myproject.example.service;

import com.myproject.example.dao.EmployeeDao;
import com.myproject.example.model.EmployeeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by stpl on 18/12/18.
 */
@Service
public class EmployeeManagerImpl<T extends EmployeeVO, I> implements EmployeeManager<T, I> {
    @Autowired
    EmployeeDao employeeDao;


    @Override
    @Transactional(readOnly = true)
    public List<T> getAllList() {
        return employeeDao.getListEmployee();
    }

    @Override
    public String addItem(T t) {
        if (t != null) {
            employeeDao.addEmployee(t);
            return "item  added sucessfully";
        } else {
            return "item not added sucessfully";
        }
    }

    @Override
    public String deleteItem(T t) {
        return null;
    }

    @Override
    public String updateItem(I id) {
        return null;
    }
}
