package servlet;

import dto.CarDto;
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
import org.apache.commons.lang3.math.NumberUtils;
import service.CarService;
import service.ServiceService;

@WebServlet("/service-view")
public class ServiceSingleCarServlet extends HttpServlet {

  @Inject
  TemplateProvider templateProvider;

  @Inject
  CarService carService;

  @Inject
  ServiceService serviceService;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    PrintWriter printWriter = resp.getWriter();
    String position = (String) req.getSession().getAttribute("type");

    Template template = templateProvider.getTemplate(getServletContext(),("services-single-car-view.ftlh"));

    String parameter = req.getParameter("id");
    Long carId= 1L;
    if (NumberUtils.isDigits(parameter)) {
      carId = Long.parseLong(parameter);
    }
    CarDto car = carService.findCarById(carId);


    Map<String, Object> dataModel = new HashMap<>();

    dataModel.put("type",position);
    dataModel.put("car",car);
    dataModel.put("services", serviceService.findServiceByCarId(carId));

    try {
      template.process(dataModel,printWriter);
    } catch (TemplateException e) {
      e.printStackTrace();
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String delete = req.getParameter("delete");
    Long carId = serviceService.findCarIdByServiceId(Long.parseLong(delete));
    serviceService.deleteService(serviceService.findServiceById(Long.parseLong(delete)));
    resp.sendRedirect("/service-view?id=" + carId);
  }
}
