package dao;

import entity.Car;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class CarDaoBean {

  @PersistenceContext
  private EntityManager entityManager;

  public void saveCar(Car car) {
    entityManager.persist(car);
  }

  public Car findCarById(Long id) {
    return entityManager.find(Car.class, id);
  }

  public List<Car> findCarsList(){
    Query query = entityManager.createNamedQuery("Cars.findAll", Car.class);
    return query.getResultList();
  }

  public List<Car> findCarsListByDepartment(String city) {
    Query query = entityManager.createNamedQuery("Cars.findCarsByDepartment");
    query.setParameter("city", city);
    return query.getResultList();
  }

  public List<Car> findCarsListByBrand(String name) {
    Query query = entityManager.createNamedQuery("Cars.findCarsByBrands");
    query.setParameter("name", name);
    return query.getResultList();
  }

  public List<Car> findCarsListByModel(String name) {
    Query query = entityManager.createNamedQuery("Cars.findCarsByModel");
    query.setParameter("name", name);
    return query.getResultList();
  }

  public Car findCarByServiceId(Long id){
    Query query = entityManager.createNamedQuery("Cars.findCarByServiceId");
    query.setParameter("id", id);
    return (Car) query.getSingleResult();
  }
}
