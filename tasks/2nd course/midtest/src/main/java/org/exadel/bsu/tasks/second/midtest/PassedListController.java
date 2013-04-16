package org.exadel.bsu.tasks.second.midtest;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author skrauchenia
 */
@Controller
public class PassedListController {

    @Autowired
    private WordSequenceAnswersStorage answersRegistrant;

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public ModelAndView handleRequest() {
        ModelAndView modelAndView = new ModelAndView("passed-list");
        List<Map.Entry<Object,Object>> students = Lists.newArrayList(answersRegistrant.getAll());
        sortStudents(students);
        List<Map.Entry<Object,Object>> replaced = replaceValuesWithDates(students);
        modelAndView.addObject("passedStudents", replaced);
        return modelAndView;
    }

    private List<Map.Entry<Object,Object>> replaceValuesWithDates(List<Map.Entry<Object, Object>> students) {
        List<Map.Entry<Object,Object>> result = Lists.newArrayList();
        Iterator<Map.Entry<Object,Object>> iterator = students.iterator();
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        while (iterator.hasNext()) {
            Map.Entry<Object, Object> entry = iterator.next();
            Date registerDate = new Date(Long.parseLong(entry.getValue().toString()));
            Map.Entry newEntry = new AbstractMap.SimpleEntry(entry.getKey(), formatter.format(registerDate));
            result.add(newEntry);
        }

        return result;
    }

    private void sortStudents(List<Map.Entry<Object, Object>> students) {
        Collections.sort(students, new Comparator<Map.Entry<Object, Object>>() {
            @Override
            public int compare(Map.Entry<Object, Object> o1, Map.Entry<Object, Object> o2) {
                return (Long.valueOf(o2.getValue().toString())).compareTo(Long.valueOf(o1.getValue().toString()));
            }
        });
    }

}
