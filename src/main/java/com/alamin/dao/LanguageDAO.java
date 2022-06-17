package com.alamin.dao;

import com.alamin.models.Language;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
