package mapper.reverseMapper;

import dao.CarDaoBean;
import dao.ServiceDaoBean;
import dto.ServiceDto;
import entity.Service;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class ServiceMapper {

  @EJB
  ServiceDaoBean serviceDaoBean;

  @EJB
  CarDaoBean carDaoBean;

  public Service mapService (ServiceDto serviceDto){
    Service service = new Service();
    service.setId(serviceDto.getId());
    service.setMileage(serviceDto.getMileage());
    service.setFixes(serviceDto.getFixes());
    service.setCars(carDaoBean.findCarByServiceId(serviceDto.getId()));
    return service;
  }

}
