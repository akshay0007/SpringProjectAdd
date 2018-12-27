package com.myproject.example.dao;

import java.util.List;

/**
 * Created by stpl on 18/12/18.
 */
//I interger//T EmployeeVO
public interface EmployeeDao<T, I> {
     void addEmployee(T t);

     List<T> getListEmployee();

     void removeEmployee(I i);

     void updateEmployee(T t);
}
