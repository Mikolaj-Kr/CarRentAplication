package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({
    @NamedQuery(
        name = "Service.findServiceByCar",
        query = "SELECT s FROM Service s WHERE s.cars.id=?1"
    )
})
@Entity
@Table(name = "service")
public class Service {

  @Id
  @GeneratedValue
  @Column(name = "service_id")
  Long id;

  @Column(name = "mileage")
  Long mileage;

  @Column(name = "fixes")
  String fixes;

  @ManyToOne
  @JoinColumn(name = "car_id")
  Car cars;

  public Service() {
  }

  public Service(Long mileage, String fixes) {
    this.mileage = mileage;
    this.fixes = fixes;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getMileage() {
    return mileage;
  }

  public void setMileage(Long mileage) {
    this.mileage = mileage;
  }

  public String getFixes() {
    return fixes;
  }

  public void setFixes(String fixes) {
    this.fixes = fixes;
  }

  public Car getCars() {
    return cars;
  }

  public void setCars(Car cars) {
    this.cars = cars;
  }
}
