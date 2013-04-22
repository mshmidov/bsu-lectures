package org.exadel.bsu.lectures.second.hibernate.web;

import org.exadel.bsu.lectures.second.hibernate.model.Comment;
import org.exadel.bsu.lectures.second.hibernate.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/blog/post")
public class BlogPostController {

    @Autowired
    private PostService postService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView getBlogPost(@PathVariable String id) {

        final ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("post", postService.getPost(id));

        modelAndView.setViewName("post");

        return modelAndView;
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
    public String deleteBlogPost(@PathVariable String id) {

        postService.deletePost(id);

        return "redirect:/blog";
    }

    @RequestMapping(value = "/{id}/comment", method = RequestMethod.POST)
    public String postBlogPostComment(@PathVariable String id, @RequestParam String author, @RequestParam String text) {

        postService.addComment(id, new Comment(author, text));

        return "redirect:/blog/post/" + id;
    }
}
