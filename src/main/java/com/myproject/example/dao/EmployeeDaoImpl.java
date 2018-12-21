package com.myproject.example.dao;

import com.myproject.example.model.EmployeeVO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by stpl on 18/12/18.
 */
@Repository
@Transactional
public class EmployeeDaoImpl<T, I> implements EmployeeDao<T, I> {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void addEmployee(T t) {
        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.save(t);
            session.getTransaction().commit();
        } catch (Exception ex) {
            session.beginTransaction().rollback();
            session.close();
        }
    }

    @Override
    public void removeEmployee(I i) {
    }


    @Override
    public List<T> getListEmployee() {
        return sessionFactory
                .getCurrentSession()
                .createCriteria(EmployeeVO.class)
                .list();
    }

    @Override
    public void updateEmployee(T t) {

    }
}
