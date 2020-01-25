package com.epam.dao;



public interface DAO<T > {
    boolean insert(T entity) throws DAOException;
    //List<T> select() throws DAOException;
}
