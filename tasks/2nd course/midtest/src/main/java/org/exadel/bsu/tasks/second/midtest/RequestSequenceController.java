package org.exadel.bsu.tasks.second.midtest;

import org.exadel.bsu.tasks.second.midtest.text.TextStudentMapper;
import org.exadel.bsu.tasks.second.midtest.text.processors.TextProcessor;
import org.exadel.bsu.tasks.second.midtest.util.StudentIdConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author skrauchenia
 */
@Controller
public class RequestSequenceController {

    @Autowired
    private TextProcessor<List<String>> mostPopularTextProcessor;

    @Autowired
    private EhCacheCacheManager cacheManager;

    @Autowired
    private TextStudentMapper textStudentMapper;

    @RequestMapping("{studentName}/sequence/{word}/{index}")
    public void handleRequest(@PathVariable("studentName") String studentName,
                              @PathVariable("word") String word,
                              @PathVariable("index") Integer index,
                              HttpServletResponse response,
                              HttpServletRequest request) {

        String studentId = StudentIdConstructor.construct(studentName, request.getRemoteAddr());
        String textFileName = textStudentMapper.get(studentId);
        mostPopularTextProcessor.process(textFileName);
    }
}
