package org.exadel.bsu.lectures.second.hibernate.dao;

import org.exadel.bsu.lectures.second.hibernate.model.Post;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostDaoImpl extends AbstractDao<Post, String> implements PostDao {

    @Autowired
    private SessionFactory sessionFactory;

    public PostDaoImpl() {
        super(Post.class);
    }

    @Override
    protected SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public List<Post> list() {
        return sessionFactory.getCurrentSession().createCriteria(Post.class).addOrder(Order.desc("timestamp")).list();
    }
}
