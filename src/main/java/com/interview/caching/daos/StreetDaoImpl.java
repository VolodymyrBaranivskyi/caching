package com.interview.caching.daos;

import com.interview.caching.daos.interfaces.StreetDao;
import com.interview.caching.model.Street;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StreetDaoImpl extends AbstractDaoImpl implements StreetDao {

    @Autowired
    protected StreetDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public List<Street> getCordinate(String name) {
        return getCurrentSession()
                .createQuery(
                        "SELECT DISTINCT street " +
                                "FROM Street street " +
                                "WHERE  " +
                                "    street.name = :name ",
                        Street.class)
                .setParameter("name", name)
                .setMaxResults(1)
                .getResultList();
    }

    @Override
    public void saveStreet(Street street) {
        Session session = getCurrentSession();
        session.save(street);
    }
}
