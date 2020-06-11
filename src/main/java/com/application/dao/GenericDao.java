package com.application.dao;

import java.util.List;

public interface GenericDao<T, K> {

  //  List<T> findAll();

    T findOne(K key);

    T create(T entity);

    T update(T entity);

    void delete(T entity);

    void deleteById(K key);
}
