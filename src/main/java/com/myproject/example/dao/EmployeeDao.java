package com.myproject.example.dao;

import java.util.List;

/**
 * Created by stpl on 18/12/18.
 */
//I interger//T EmployeeVO
public interface EmployeeDao<T, I> {
    public void addEmployee(T t);

    public void removeEmployee(I i);

    public List<T> getListEmployee();

    public void updateEmployee(T t);
}
