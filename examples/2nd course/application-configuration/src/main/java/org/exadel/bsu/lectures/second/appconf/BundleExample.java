package org.exadel.bsu.lectures.second.appconf;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author skrauchenia
 */
public class BundleExample {

    public static void main(String[] args) {
        testBundle("bundles.demo_bundle", Locale.US);
        testBundle("bundles.demo_bundle", new Locale("ru", "RU"));
    }

    private static void testBundle(String bundleBaseName, Locale locale) {
        ResourceBundle bundle;
        bundle = ResourceBundle.getBundle(bundleBaseName, locale);
        String value = bundle.getString("messages.greeting");

        System.out.println(locale + " [messages.greeting] = " + value);
    }
}
