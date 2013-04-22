package org.exadel.bsu.lectures.second.hibernate.dao;

import org.exadel.bsu.lectures.second.hibernate.model.Comment;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class CommentDaoImpl extends AbstractDao<Comment, String> implements CommentDao {

    @Autowired
    private SessionFactory sessionFactory;

    protected CommentDaoImpl() {
        super(Comment.class);
    }

    @Override
    public List<Comment> list() {
        return Collections.emptyList();
    }

    @Override
    protected SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
