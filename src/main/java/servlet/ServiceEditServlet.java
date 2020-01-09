package servlet;

import dao.CarDaoBean;
import dto.ServiceDto;
import entity.Service;
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
import mapper.ServiceDtoMapper;
import service.ServiceService;

@WebServlet("/service-edit")
public class ServiceEditServlet extends HttpServlet {

  @Inject
  TemplateProvider templateProvider;

  @Inject
  ServiceService serviceService;

  @Inject
  CarDaoBean carDaoBean;

  @Inject
  ServiceDtoMapper serviceDtoMapper;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    PrintWriter printWriter = resp.getWriter();

    Template template = templateProvider.getTemplate(getServletContext(), ("service-edit.ftlh"));

    String position = (String) req.getSession().getAttribute("type");
    String serviceId = req.getParameter("id");

    ServiceDto serviceDto = serviceDtoMapper.mapServiceToDto(serviceService.findServiceById(Long.parseLong(serviceId)));

    Map<String, Object> dataModel = new HashMap<>();
    dataModel.put("type", position);
    dataModel.put("service", serviceDto);



    try {
      template.process(dataModel, printWriter);
    } catch (TemplateException e) {
      e.printStackTrace();
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String fixes = req.getParameter("fixes");
    String mileage = req.getParameter("mileage");
    String serviceId = req.getParameter("car-service");
    Service service = new Service();
    service.setMileage(Long.parseLong(mileage));
    service.setFixes(fixes);
    service.setId(Long.parseLong(serviceId));
    service.setCars(carDaoBean.findCarById(serviceService.findCarIdByServiceId(Long.parseLong(serviceId))));
    serviceService.editService(service);
    resp.sendRedirect("/service-view?id=" + serviceService.findCarIdByServiceId(Long.parseLong(serviceId)));

  }
}
