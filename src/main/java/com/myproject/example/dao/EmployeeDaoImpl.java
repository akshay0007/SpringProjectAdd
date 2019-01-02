package com.myproject.example.dao;

import com.myproject.example.configure.HibernateConfiguration;
import com.myproject.example.model.EmployeeVO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by stpl on 18/12/18.
 */
@Repository
@Transactional
public class EmployeeDaoImpl<T extends EmployeeVO, I extends Serializable> implements EmployeeDao<T, I> {

    private Class<T> type;

    @Override
    public void addEmployee(T t) {
        Transaction transaction = null;
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(t);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void removeEmployee(I i) {
    }


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<T> getListEmployee() {
//        Transaction transaction = null;
//        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
//            transaction = session.beginTransaction();
//            Query query = session.createQuery("from EmployeeVO");
//            List<EmployeeVO> results = query.getResultList();
//            transaction.commit();
//            return (List<T>) results;
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            if (transaction != null) {
//                transaction.rollback();
//            }
//        }
//         return null;
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from EmployeeVO");
        List<EmployeeVO> results = query.getResultList();
        return (List<T>) results;
    }

    @Override
    public void updateEmployee(T t) {

    }
}
