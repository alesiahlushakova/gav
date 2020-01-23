package com.epam.dao;

import com.epam.entity.Entity;

public interface DAO<T extends Entity> {
    boolean insert(T entity) throws DAOException;

}
