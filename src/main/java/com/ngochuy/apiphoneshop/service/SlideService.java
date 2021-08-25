package com.ngochuy.apiphoneshop.service;

import com.ngochuy.apiphoneshop.dao.SlideDAO;
import com.ngochuy.apiphoneshop.entities.Slide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SlideService {
    @Autowired
    private SlideDAO slideDAO;

    public List<Slide> getAllSlides(){
        return slideDAO.getAllSlides();
    }
}
