package org.exadel.bsu.lectures.second.networking;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class Main {

    public static void main(String[] args) throws IOException {

        resolveDns("google.com");

        inspectLocalhost();

        loadPage("http", "google.com", "");

        inspectConnection("http", "google.com", "");
    }

    private static void resolveDns(String host) throws UnknownHostException {
        System.out.println("Resolving " + host);
        final InetAddress[] addresses = InetAddress.getAllByName(host);

        for (InetAddress address : addresses) {
            System.out.println(address);
        }

        System.out.println("=========================");
    }

    private static void inspectLocalhost() throws UnknownHostException {

        System.out.println("Inspecting localhost");

        final InetAddress localHost = InetAddress.getLocalHost();

        System.out.println("host address: " + localHost.getHostAddress());
        System.out.println("host name: " + localHost.getHostName());
        System.out.println("canonical host name: " + localHost.getCanonicalHostName());

        System.out.println("=========================");
    }

    private static void loadPage(String protocol, String host, String file) throws MalformedURLException {
        System.out.println("Loading " + host);

        final URL url = new URL(protocol, host, file);

        BufferedReader stream = null;

        try {
            stream = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;

            do {
                line = stream.readLine();

                System.out.println(line);

            } while (line != null);

        } catch (IOException e) {
            System.out.println(e);

        } finally {
            close(stream);
        }

        System.out.println("=========================");
    }

    private static void inspectConnection(String protocol, String host, String file) throws IOException {
        System.out.println("Inspecting " + host);

        final URL url = new URL(protocol, host, file);

        final URLConnection connection = url.openConnection();

        System.out.println("content type: " + connection.getContentType());
        System.out.println("content encoding: " + connection.getContentEncoding());
        System.out.println("content length: " + connection.getContentLength());
        System.out.println(connection.getContent());

        System.out.println("=========================");
    }

    private static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
}
