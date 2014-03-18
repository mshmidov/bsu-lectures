package edu.security.dao;

import java.util.Collection;

public interface DAO<ID_TYPE, ENTITY_TYPE> {
    Collection<ENTITY_TYPE> getAll();

    ENTITY_TYPE get(ID_TYPE id);

    void save(ENTITY_TYPE entity);

    void delete(ID_TYPE id);
}
