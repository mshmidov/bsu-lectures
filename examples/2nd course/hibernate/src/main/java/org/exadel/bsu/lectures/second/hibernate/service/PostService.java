package org.exadel.bsu.lectures.second.hibernate.service;

import org.exadel.bsu.lectures.second.hibernate.dao.PostDao;
import org.exadel.bsu.lectures.second.hibernate.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostDao postDao;

    @Transactional(readOnly = true)
    public List<Post> getAllPosts() {
        return postDao.list();
    }

    @Transactional
    public void createPost(Post newPost) {
        postDao.create(newPost);
    }
}
