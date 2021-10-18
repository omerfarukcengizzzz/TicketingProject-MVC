package com.cybertek.service;

import java.util.List;

public interface CrudService<T, ID> {
    // save
    T save(T role);

    // findByID
    T findByID(ID id);

    // return list
    List<T> findAll();

    // delete
    void delete(T role);
    void deleteByID(ID id);
}
