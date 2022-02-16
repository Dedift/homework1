package project.tms.servletLayer.controller;

import project.tms.daoLayer.entityLayer.User.User;
import project.tms.serviceLayer.ServiceFactory;
import project.tms.serviceLayer.UserService;
import project.tms.servletLayer.util.JSPUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

@WebServlet(urlPatterns = "/frontController")
public class FrontController extends HttpServlet {

    ServiceFactory serviceFactory = ServiceFactory.getInstance();
    public static final String COMMAND_KEY = "command";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String command = req.getParameter(COMMAND_KEY);
        processCommand(req, resp, command);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String command = req.getParameter(COMMAND_KEY);
        processCommand(req, resp, command);
    }

    private void processCommand(HttpServletRequest req, HttpServletResponse resp, String command) throws IOException, ServletException {
        switch (command) {
            case "loginUser":
                loginUser(req, resp);
                break;
            case "showAllUsers":
                showAllUsers(req, resp);
                break;
            case "changeLanguage":
                changeLanguage(req, resp);
                break;
            case "registerUser":
                registerUser(req, resp);
                break;
            default:
                break;
        }
    }

    private void changeLanguage(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String lang = req.getParameter("lang");
        if ("ru".equalsIgnoreCase(lang)) {
            req.getSession().setAttribute("language", new Locale("ru", "RU"));
        } else {
            req.getSession().setAttribute("language", new Locale("en", "US"));
        }
        String from = req.getHeader("Referer");
        resp.sendRedirect(from);
    }

    private void showAllUsers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = UserService.getInstance().findAll();
        req.setAttribute("employees", users);
        req.getRequestDispatcher(req.getContextPath() + JSPUtil.getUserJSPPath("allEmployees")).forward(req, resp);
    }

    private void loginUser(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        if (serviceFactory.getUserService().validateUserByEmailAndPassword(email, password)) {
            User user = serviceFactory.getUserService().findByEmail(email).get();
            req.getSession().setAttribute("user", user);
            resp.sendRedirect(JSPUtil.getUserJSPPath("user"));
        } else {
            resp.getWriter().print("Incorrect email or password");
            resp.sendRedirect("jsp/login.jsp");
        }
    }

    private void registerUser(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String gender = req.getParameter("male");
        if (serviceFactory.getUserService().validateUserByEmailAndPassword(email, password)) {
            resp.getWriter().print("User with this email is already registered");
        } else {
            if ("on".equals(gender)){
                gender = "male";
            } else {
                gender = "female";
            }
            User user = new User(email, password, gender);
            System.out.println(user);
            serviceFactory.getUserService().save(user);
            req.getSession().setAttribute("user", user);
            resp.sendRedirect(JSPUtil.getUserJSPPath("user"));
        }
    }
}