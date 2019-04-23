/*
 * This file is generated by jOOQ.
*/
package com.example.pojo.tables.daos;


import com.example.pojo.tables.UsersInfor;
import com.example.pojo.tables.records.UsersInforRecord;

import java.util.List;

import javax.annotation.Generated;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.8"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UsersInforDao extends DAOImpl<UsersInforRecord, com.example.pojo.tables.pojos.UsersInfor, Integer> {

    /**
     * Create a new UsersInforDao without any configuration
     */
    public UsersInforDao() {
        super(UsersInfor.USERS_INFOR, com.example.pojo.tables.pojos.UsersInfor.class);
    }

    /**
     * Create a new UsersInforDao with an attached configuration
     */
    public UsersInforDao(Configuration configuration) {
        super(UsersInfor.USERS_INFOR, com.example.pojo.tables.pojos.UsersInfor.class, configuration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Integer getId(com.example.pojo.tables.pojos.UsersInfor object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<com.example.pojo.tables.pojos.UsersInfor> fetchById(Integer... values) {
        return fetch(UsersInfor.USERS_INFOR.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public com.example.pojo.tables.pojos.UsersInfor fetchOneById(Integer value) {
        return fetchOne(UsersInfor.USERS_INFOR.ID, value);
    }

    /**
     * Fetch records that have <code>user_name IN (values)</code>
     */
    public List<com.example.pojo.tables.pojos.UsersInfor> fetchByUserName(String... values) {
        return fetch(UsersInfor.USERS_INFOR.USER_NAME, values);
    }

    /**
     * Fetch records that have <code>sex IN (values)</code>
     */
    public List<com.example.pojo.tables.pojos.UsersInfor> fetchBySex(String... values) {
        return fetch(UsersInfor.USERS_INFOR.SEX, values);
    }

    /**
     * Fetch records that have <code>age IN (values)</code>
     */
    public List<com.example.pojo.tables.pojos.UsersInfor> fetchByAge(Integer... values) {
        return fetch(UsersInfor.USERS_INFOR.AGE, values);
    }
}
