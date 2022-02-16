//package project.tms.servletLayer.filter;
//
//import project.tms.daoLayer.entityLayer.User.User;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.Objects;
//
//@WebFilter(urlPatterns = "/jsp/admin/*")
//public class AutorisationAdminFilter implements Filter {
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
//        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
//        User user = (User) httpRequest.getSession().getAttribute("user");
//        if(Objects.nonNull(user) && "admin".equals(user.getRole())){
//            filterChain.doFilter(servletRequest, servletResponse);
//        } else {
//            httpResponse.sendRedirect("/jsp/user/user.jsp");
//        }
//    }
//}
