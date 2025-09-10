package ie.yawer;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class HelloServlet extends HttpServlet {

    // Display in a console to confirm the servlet was instantiated
    public HelloServlet() {
        System.out.println("HelloServlet initialized");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        // When origin (website) is hosted locally it can be for instance "http://localhost:8080"
        String TRUSTED_REQUEST_ORIGIN = "*";
        // Asterisk ("*") tells the browser: “Yes, it’s okay to accept requests from any origin.”
        resp.setHeader("Access-Control-Allow-Origin", TRUSTED_REQUEST_ORIGIN);

        // Display in a console to confirm the server was hit by request
        System.out.println("Received GET request");

        resp.setStatus(HttpServletResponse.SC_OK);
        // Response body's content, which is state of isIdle in CursorCoordsChecker
        resp.getWriter().write(CursorCoordsChecker.isIdle);
    }
}
