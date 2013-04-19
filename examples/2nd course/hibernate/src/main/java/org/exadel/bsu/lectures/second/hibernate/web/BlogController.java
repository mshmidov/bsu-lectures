package org.exadel.bsu.lectures.second.hibernate.web;

import org.exadel.bsu.lectures.second.hibernate.model.Post;
import org.exadel.bsu.lectures.second.hibernate.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BlogController {

    @Autowired
    private PostService postService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getRoot() {
        return getBlog();
    }

    @RequestMapping(value = "/blog", method = RequestMethod.GET)
    public ModelAndView getBlog() {

        final ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("blog");

        modelAndView.addObject("posts", postService.getAllPosts());

        return modelAndView;
    }

    @RequestMapping(value = "/blog/post", method = RequestMethod.POST)
    public String postBlogPost(@RequestParam final String name,
                               @RequestParam final String text) {

        postService.createPost(new Post(name, text));

        return "redirect:/blog";
    }

}
