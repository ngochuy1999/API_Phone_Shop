package com.ngochuy.apiphoneshop.dao;

import com.ngochuy.apiphoneshop.entities.Employee;
import com.ngochuy.apiphoneshop.entities.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public Employee getEmployee(int empId){
        Session session = sessionFactory.getCurrentSession();
        Employee employee = (Employee) session.get(Employee.class,empId);
        return employee;
    }
}
