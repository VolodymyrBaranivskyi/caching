package com.interview.caching.daos;

import com.interview.caching.daos.interfaces.AbstractDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public abstract class AbstractDaoImpl implements AbstractDao {

    private final SessionFactory sessionFactory;

    protected AbstractDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    Session getCurrentSession() {
        sessionFactory.openStatelessSession();
        return sessionFactory.getCurrentSession();
    }

    Session openSession() {
        return sessionFactory.openSession();
    }
}
