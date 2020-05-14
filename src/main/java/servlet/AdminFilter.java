package servlet;


import javax.servlet.*;
import javax.servlet.Filter;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/admin/*")
public class AdminFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Фильтр админа инициализирован");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();

        //Существует ли сессиия
        boolean loggedIn = session != null && session.getAttribute("username") != null && session.getAttribute("role") != null;
        if (loggedIn) {
            //Если существует то получаем роль
            String userRole = session.getAttribute("role").toString();
            if (userRole.equals("user")) {
                response.sendRedirect(request.getContextPath() + "/user");
            } else if (userRole.equals("admin")) {
                filterChain.doFilter(request, response);
            }
            //Если нет то на страницу входа.
        } else response.sendRedirect(request.getContextPath() + "login.jsp");
    }

    @Override
    public void destroy() {
    }
}
