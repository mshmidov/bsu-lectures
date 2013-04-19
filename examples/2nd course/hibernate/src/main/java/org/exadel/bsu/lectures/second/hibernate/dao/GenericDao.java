package org.exadel.bsu.lectures.second.hibernate.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @author mshmidov
 */
public interface GenericDao<E, K extends Serializable> {

    K create(E entity);

    E read(K id);

    void update(E entity);

    void delete(E entity);

    List<E> list();
}
