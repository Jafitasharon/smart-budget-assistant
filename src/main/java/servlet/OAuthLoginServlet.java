package servlet;

import database.UserDAO;
import model.User;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import com.google.gson.Gson;

@WebServlet("/oauth-login")
public class OAuthLoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        String provider = req.getParameter("provider");
        String oauthId = req.getParameter("oauthId");
        String name = req.getParameter("name");
        String email = req.getParameter("email");

        if (provider == null || oauthId == null || email == null) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write("{\"error\":\"Missing required fields\"}");
            return;
        }

        // Check if user already exists
        User user = UserDAO.findUserByOAuth(provider, oauthId);

        if (user == null) {
            // Create new OAuth user
            user = UserDAO.createOAuthUser(provider, oauthId, name, email);
        }

        if (user != null) {
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.getWriter().write(new Gson().toJson(user));
        } else {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.getWriter().write("{\"error\":\"Failed to log in\"}");
        }
    }
}
