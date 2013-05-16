package org.exadel.lectures.second.web.part2;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * This example demonstrates usage of content type image/jpeg
 * <p/>
 * Created by Sergey Derugo
 */
public class ImageServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Tell to the browser that this response is an image
        response.setContentType("image/jpeg");
        ServletOutputStream outputStream = response.getOutputStream();

        String text = request.getParameter("text");
        BufferedImage image = createImage(text);
        ImageIO.write(image, "JPEG", outputStream);
    }

    private BufferedImage createImage(String text) {
        BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();
        graphics.setFont(new Font("Arial", Font.BOLD, 20));

        graphics.drawString(text, 30, 55);

        return image;
    }
}