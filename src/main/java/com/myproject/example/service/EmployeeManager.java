package com.myproject.example.service;

import java.util.List;

/**
 * Created by stpl on 18/12/18.
 */

public interface EmployeeManager<T, I> {

    List<T> getAllList();

    String addItem(T t);

    String deleteItem(T t);

    String updateItem(I id);
}
