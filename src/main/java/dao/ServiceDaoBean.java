package dao;

import entity.Service;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class ServiceDaoBean {

  @PersistenceContext
  private EntityManager entityManager;

  public void saveService(Service service) {
    entityManager.persist(service);
  }

  public void deleteService(Service service) {
    entityManager.remove(entityManager.contains(service) ? service : entityManager.merge(service));
  }

  public Service findServiceById(Long id) {
    return entityManager.find(Service.class, id);
  }

  public List<Service> findServiceByCarId(Long id) {
    Query query = entityManager.createNamedQuery("Service.findServiceByCar");
    query.setParameter(1, id);
    return query.getResultList();
  }
}
