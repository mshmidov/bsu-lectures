package org.exadel.lectures.second.web.part2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * This example demonstrates how to implement download functionality.
 * <p/>
 * Created by Sergey Derugo
 */
public class FileServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Get file somewhere, for example, generate it on the fly
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintWriter writer = new PrintWriter(stream);
        writer.println("Lorem ipsum dolor sit amet...");
        writer.print("Generated for id=" + request.getParameter("id"));
        writer.flush();
        byte[] data = stream.toByteArray();

        //Tell to the browser that this response is an image
        response.setHeader("Content-type", "application/download");
        response.setHeader("Content-length", Integer.toString(data.length));
        response.setHeader("Content-transfer-encodig", "binary");
        response.setHeader("Content-disposition", "attachment; filename=MyFile.txt");

        //Write bytes
        response.getOutputStream().write(data);
    }
}