package org.exadel.bsu.lectures.second.networking;

import java.io.*;
import java.net.*;

public class Main {

    public static void main(String[] args) throws IOException {

        resolveDns("google.com");

        inspectLocalhost();

        loadPage("http", "google.com", "/intl/en/about/");

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
        System.out.println("Loading " + host + file);

        final URL url = new URL(protocol, host, file);

        BufferedReader stream = null;

        try {
            stream = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;

            while((line = stream.readLine()) != null) {
                System.out.println(line);
            }

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

    private static void testSocket() {
        Socket socket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            socket = new Socket("some host", 7);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out.println("request");
            final String response = in.readLine();

        } catch (UnknownHostException e) {
            System.err.println(e);
        } catch (IOException e) {
            System.err.println(e);

        } finally {
            close(out);
            close(in);
            close(socket);
        }
    }

    public static String excutePost(String targetURL, String urlParameters)
    {
        URL url;
        HttpURLConnection connection = null;
        try {
            url = new URL(targetURL);

            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            connection.setRequestProperty("Content-Length", "" + Integer.toString(urlParameters.getBytes().length));
            connection.setRequestProperty("Content-Language", "en-US");

            connection.setUseCaches (false);
            connection.setDoInput(true);
            connection.setDoOutput(true);

            //Send request
            DataOutputStream wr = new DataOutputStream (connection.getOutputStream ());
            wr.writeBytes (urlParameters);
            wr.flush ();
            wr.close ();

            //Get Response
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            String line;
            StringBuffer response = new StringBuffer();
            while((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();
            return response.toString();

        } catch (Exception e) {

            e.printStackTrace();
            return null;

        } finally {

            if(connection != null) {
                connection.disconnect();
            }
        }
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

    private static void close(Socket closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
}
