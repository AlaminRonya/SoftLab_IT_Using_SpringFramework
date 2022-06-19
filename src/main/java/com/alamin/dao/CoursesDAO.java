package com.alamin.dao;

import com.alamin.models.Courses;
import com.alamin.models.Language;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CoursesDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public Long insert(Courses course) {
        Session session = sessionFactory.getCurrentSession();
        try {
            return  (Long) session.save(course);
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.flush();

        return null;
    }

    public List<Courses> getAll(){
        return sessionFactory.getCurrentSession().createQuery("FROM Courses").list();
    }
}
