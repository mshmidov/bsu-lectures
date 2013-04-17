package org.exadel.bsu.tasks.second.midtest.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @author skrauchenia
 */
@Component
public class StudentNameCoder {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentNameCoder.class);

    @Cacheable("student-coder")
    public String decode(String code) {
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            return new String(decoder.decodeBuffer(code));
        } catch (IOException e) {
            LOGGER.error("Failed to decode code <{}>. Empty string will be used instead", code, e);
            return "";
        }
    }

    @Cacheable("student-coder")
    public String encode(String studentName) {
        BASE64Encoder encoder = new BASE64Encoder();
        try {
            return encoder.encode(studentName.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("I'd like to see that situation actually. <{}>", studentName, e);
            return null;
        }
    }
}
