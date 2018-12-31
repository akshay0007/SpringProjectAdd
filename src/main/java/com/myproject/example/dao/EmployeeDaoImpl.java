package com.myproject.example.dao;

import com.myproject.example.configure.HibernateUtils;
import com.myproject.example.model.EmployeeVO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Root;

/**
 * Created by stpl on 18/12/18.
 */
@Repository("employeeDaoImpl")
@Transactional
public class EmployeeDaoImpl<T, I> implements EmployeeDao<T, I> {

    @Override
    public void addEmployee(T t) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(t);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void removeEmployee(I i) {
    }


    @Override
    public List<T> getListEmployee() {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<EmployeeVO> query = builder.createQuery(EmployeeVO.class);
            Root<EmployeeVO> root = query.from(EmployeeVO.class);
            query.select(root);
            Query<EmployeeVO> q = session.createQuery(query);
            List<EmployeeVO> employees = q.getResultList();
            for (EmployeeVO employee : employees) {
                System.out.println(employee.getFirstName());
            }
            transaction.commit();
            return (List<T>) employees;
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return null;
    }

    @Override
    public void updateEmployee(T t) {

    }
}
