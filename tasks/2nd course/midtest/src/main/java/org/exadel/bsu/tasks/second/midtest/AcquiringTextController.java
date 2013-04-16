package org.exadel.bsu.tasks.second.midtest;

import org.apache.commons.io.IOUtils;
import org.exadel.bsu.tasks.second.midtest.text.TextFileNamesContainer;
import org.exadel.bsu.tasks.second.midtest.text.TextStudentMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author skrauchenia
 */
@Controller
public class AcquiringTextController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AcquiringTextController.class);

    @Autowired
    private TextFileNamesContainer bookUserMappingContainer;

    @Autowired
    private TextStudentMapper bookStudentMapper;

    @RequestMapping("{studentId}/text")
    public void acquireText(@PathVariable("studentId") String studentId,
                            HttpServletResponse response, HttpServletRequest request) throws IOException {
        String bookFile = bookUserMappingContainer.pickUpNameRandomly();
        LOGGER.info("Book <{}> picked up randomly for <{}>", bookFile, studentId);
        bookStudentMapper.put(studentId, bookFile);
        InputStream stream = this.getClass().getClassLoader().getResourceAsStream(bookFile);
        IOUtils.copy(stream, response.getWriter());
    }
}
