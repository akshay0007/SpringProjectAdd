package com.myproject.example.dao;

import com.myproject.example.model.EmployeeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stpl on 18/12/18.
 */
@Repository
public class EmployeeDaoImpl<T, I> implements EmployeeDao<T, I> {

    @Autowired
    EmployeeDao dao;
    private static List listData;

    static {
        listData = new ArrayList();
        listData.add(new EmployeeVO(1, "name1", "lastname1"));
        listData.add(new EmployeeVO(2, "name1", "lastname1"));
        listData.add(new EmployeeVO(3, "name1", "lastname1"));
        listData.add(new EmployeeVO(4, "name1", "lastname1"));

    }

    @Override
    public void addEmployee(T t) {
    }

    @Override
    public void removeEmployee(I i) {
    }

    @Override
    public List<T> getListEmployee() {
        if (listData == null)
            return new ArrayList();
        if (listData.size() == 0)
            return new ArrayList();
        return listData;
    }

    @Override
    public void updateEmployee(T t) {

    }
}
