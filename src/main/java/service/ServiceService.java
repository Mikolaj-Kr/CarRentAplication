package service;

import dao.CarDaoBean;
import dao.ServiceDaoBean;
import dto.ServiceDto;
import entity.Service;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import mapper.CarDtoMapper;
import mapper.ServiceDtoMapper;

@Stateless
public class ServiceService {

  @EJB
  ServiceDaoBean serviceDaoBean;

  @EJB
  ServiceDtoMapper serviceDtoMapper;

  @EJB
  CarDaoBean carDaoBean;

  @EJB
  CarDtoMapper carDtoMapper;

  public List<ServiceDto> findServiceByCarId(Long id) {
    List<Service> serviceList = serviceDaoBean.findServiceByCarId(id);
    List<ServiceDto> serviceDtoList = new ArrayList<>();
    for (Service service : serviceList) {
      serviceDtoList.add(serviceDtoMapper.mapServiceToDto(service));
    }
    return serviceDtoList;
  }

  public void addService(Long mileage, Long carId, String fixes){
    Service service = new Service();
    service.setCars(carDaoBean.findCarById(carId));
    service.setFixes(fixes);
    service.setMileage(mileage);

  }
}
