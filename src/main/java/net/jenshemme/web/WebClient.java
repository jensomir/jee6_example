package net.jenshemme.web;

import net.jenshemme.domain.Project;
import net.jenshemme.service.HousePlanner;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * For testing purposes.
 */
@WebServlet(urlPatterns = "/myClient")
public class WebClient extends HttpServlet {

    @Inject
    HousePlanner planningService;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Project p = planningService.createProject(null, null);
        out.println(p.getProjectManager());
        out.close();
    }


}
