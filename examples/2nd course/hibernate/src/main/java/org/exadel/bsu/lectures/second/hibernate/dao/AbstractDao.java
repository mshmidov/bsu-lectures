package org.exadel.bsu.lectures.second.hibernate.dao;

import org.hibernate.SessionFactory;

import java.io.Serializable;

public abstract class AbstractDao<E, K extends Serializable> implements GenericDao<E, K> {

    protected abstract SessionFactory getSessionFactory();

    private final Class<E> entityClass;

    protected AbstractDao(Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public K create(final E entity) {
        return (K) getSessionFactory().getCurrentSession().save(entity);
    }

    @Override
    public E read(final K id) {
        final Object result = getSessionFactory().getCurrentSession().get(entityClass, id);

        return (result != null && entityClass.isAssignableFrom(result.getClass()))
               ? entityClass.cast(result)
               : null;
    }

    @Override
    public void update(final E entity) {
        getSessionFactory().getCurrentSession().merge(entity);
    }

    @Override
    public void delete(final E entity) {
        getSessionFactory().getCurrentSession().delete(entity);
    }

}
