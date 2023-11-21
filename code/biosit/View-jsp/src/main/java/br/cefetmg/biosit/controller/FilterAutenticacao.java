package br.cefetmg.biosit.controller;

import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter("/*")
public class FilterAutenticacao implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession session = httpRequest.getSession(false);

        boolean isAuthenticated = session != null && session.getAttribute("usuarioLogado") != null;
        
        String path = ((HttpServletRequest) request).getServletPath();
        if (path.startsWith("/estilos/") || path.startsWith("/imgs/"))
            chain.doFilter(request, response);

        if (isAuthenticated || isLoginPage(httpRequest) || isFacadePage(httpRequest)) {
            chain.doFilter(request, response);
        } else {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.jsp");
        }
    }

    @Override
    public void destroy() {

    }

    private boolean isLoginPage(HttpServletRequest request) {
        String loginPage = request.getContextPath() + "/login.jsp";
        return request.getRequestURI().equals(loginPage);
    }
    
    private boolean isFacadePage(HttpServletRequest request) {
        String loginPage = request.getContextPath() + "/Facade";
        return request.getRequestURI().equals(loginPage);
    }
}


