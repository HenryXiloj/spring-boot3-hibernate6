package com.henry.repository.impl;

import com.henry.repository.UserRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.jdbc.ReturningWork;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Integer getSum(int a, int b) {

        Session session = entityManager.unwrap(Session.class);

        int result = session.doReturningWork(new ReturningWork<Integer>() {
            @Override
            public Integer execute(Connection connection) throws SQLException {
                CallableStatement call = connection.prepareCall("{ ? = call get_sum(?,?) }");
                call.registerOutParameter(1, Types.INTEGER); // or whatever it is
                call.setInt(2, a);
                call.setInt(3, b);
                call.execute();
                return call.getInt(1); // propagate this back to enclosing class
            }
        });

        return  result;
    }
}
