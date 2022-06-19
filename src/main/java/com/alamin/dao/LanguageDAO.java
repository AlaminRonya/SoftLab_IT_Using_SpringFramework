package com.alamin.dao;

import com.alamin.models.Language;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LanguageDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public Long insert(Language language) {
        Session session = sessionFactory.getCurrentSession();
        try {
            return  (Long) session.save(language);
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.flush();
        return null;
    }

    public List<Language> getAll(){
//        Query query = sessionFactory.getCurrentSession().createQuery("FROM Language");
//        List<Language> languages = query.list();
        return sessionFactory.getCurrentSession().createQuery("FROM Language").list();
    }
}
