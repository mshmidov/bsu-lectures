package org.exadel.bsu.tasks.second.midtest;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author skrauchenia
 */
@Controller
public class SortedLinesController {

    @RequestMapping(value = "/hello", method = RequestMethod.PUT)
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String a = IOUtils.toString(request.getInputStream());
        System.out.println(a);
    }
}
