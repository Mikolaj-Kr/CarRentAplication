package dao;

import entity.Equipment;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EquipmentDaoBean {

  @PersistenceContext
  private EntityManager entityManager;

  public void saveBrand(Equipment equipment) {
    entityManager.persist(equipment);
  }

  public Equipment findBrandById(Long id) {
    return entityManager.find(Equipment.class, id);
  }
}
