package org.exadel.bsu.lectures.second.appconf;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

/**
 * @author skrauchenia
 */
public class PropertiesExample {

    public static void main(String[] args) {
        Properties properties = new Properties();

        String file = "test.properties";
        ClassLoader cl = PropertiesExample.class.getClassLoader();
        InputStream stream = cl.getResourceAsStream(file);
        try {
            properties.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Map.Entry entry : properties.entrySet()) {
            System.out.println(entry);
        }
    }
}
