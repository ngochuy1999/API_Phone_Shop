package com.ngochuy.apiphoneshop.dao;

import com.ngochuy.apiphoneshop.entities.Slide;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SlideDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public List<Slide> getAllSlides() {
        Session session = sessionFactory.getCurrentSession();
        List<Slide> listSlides = (List<Slide>) session.createQuery("from " + Slide.class.getName()).list();
        System.out.println(listSlides);
        return listSlides;
    }
}
