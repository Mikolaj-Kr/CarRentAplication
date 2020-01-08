package servlet;

import freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.ServiceService;

@WebServlet("/service-add")
public class ServiceAddNewServlet extends HttpServlet {

  @Inject
  TemplateProvider templateProvider;

  @Inject
  ServiceService serviceService;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    PrintWriter printWriter = resp.getWriter();

    Template template = templateProvider.getTemplate(getServletContext(),("service-add-new.ftlh"));

    String position = (String) req.getSession().getAttribute("type");

    String id = req.getParameter("id");

    req.getSession().setAttribute("id", id);

    Map<String,Object> dataModel = new HashMap<>();

    dataModel.put("type", position);
    dataModel.put("id", id);

    try {
      template.process(dataModel, printWriter);
    } catch (TemplateException e) {
      e.printStackTrace();
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    PrintWriter printWriter = resp.getWriter();
    String mileage = req.getParameter("mileage");
    String fixes = req.getParameter("fixes");
    String id = (String) req.getSession().getAttribute("id");
    serviceService.addService(Long.parseLong(mileage), Long.parseLong(id), fixes);
    req.getSession().setAttribute("id",null);
    resp.sendRedirect("/service-view?id=" + id);
  }
}
