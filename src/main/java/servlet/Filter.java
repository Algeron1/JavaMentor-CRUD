package servlet;

import DAO.UserDAO;
import model.User;
import service.UserService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;

@WebFilter({"/admin/*", "/user/*", "/"})
public class Filter extends HttpServlet implements javax.servlet.Filter {

    UserService userService = new UserService();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);
        String loginURI = request.getContextPath() + "/login.jsp";
        boolean loggedIn = (session != null && session.getAttribute("username") != null && session.getAttribute("role") != null);
        boolean loginRequest = request.getRequestURI().equals(loginURI);
        if (loggedIn || loginRequest) {
            filterChain.doFilter(request, response);
        } else {
            String userName = request.getParameter("username");
            String password = request.getParameter("password");
            User user = userService.getUser(userName, password);
            String role = userService.getRole(userName, password);
            if (role == null) {
                response.sendRedirect("/login.jsp");
            } else if (role.equals("admin")) {
                session.setAttribute("role", role);
                session.setAttribute("username", userName);
                response.sendRedirect("/admin/list");
            } else if (role.equals("user")) {
                List<User> listUser = new ArrayList<>();
                listUser.add(user);
                session.setAttribute("username", userName);
                session.setAttribute("role", role);
                request.setAttribute("listUser", listUser);
                request.getRequestDispatcher("/user/user-view.jsp").forward(request, response);
            }
        }
    }

    @Override
    public void destroy() {
        System.out.println("Фильтр завершил работу");
    }

}
