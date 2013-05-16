package org.exadel.lectures.second.web.part2;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;

/**
 * Created by Sergey Derugo
 * Date: 5/15/12
 * Time: 2:02 PM
 */
@MultipartConfig
public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Collection<Part> parts = request.getParts();
        for (Part part : parts) {
            String contentType = part.getContentType();
            System.out.println("contentType = " + contentType);

            System.out.println("file = " + getFileName(part));

            InputStream stream = part.getInputStream();
            String content = readAsString(stream);
            System.out.println("content = " + content);
        }

        response.getOutputStream().println("<html><body>The file has been uploaded</body></html>");
    }

    private String readAsString(InputStream stream) throws IOException {
        String result = "";
        InputStreamReader inputReader = new InputStreamReader(stream);
        BufferedReader reader = new BufferedReader(inputReader);
        while (reader.ready()) {
            result += reader.readLine();
        }

        return result;
    }

    private String getFileName(Part part) {
        String[] contentAttributes = part.getHeader("content-disposition").split(";");
        for (String attribute : contentAttributes) {
            if (attribute.trim().startsWith("filename")) {
                String value = attribute.substring(attribute.indexOf('=') + 1).trim();
                return value.replace("\"", "");
            }
        }

        return null;
    }
}