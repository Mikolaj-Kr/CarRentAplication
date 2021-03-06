package entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@NamedQueries({
    @NamedQuery(
        name = "Departments.findAll",
        query = "SELECT d FROM Department d"
    ),

    @NamedQuery(
        name = "Department.findWarszawa",
        query = "SELECT d FROM Department d WHERE d.city LIKE 'Warszawa'"
    ),

})

@Entity
@Table(name = "department")
public class Department {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "department_id")
  Long id;

  @Column(name = "city")
  String city;

  @OneToMany(mappedBy = "department")
  List<Worker> workers = new ArrayList<>();

  @OneToMany(mappedBy = "department")
  List<Car> cars = new ArrayList<>();

  public Department() {
  }

  public Department(String city) {
    this.city = city;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public List<Worker> getWorkers() {
    return workers;
  }

  public void setWorkers(List<Worker> workers) {
    this.workers = workers;
  }

  public List<Car> getCars() {
    return cars;
  }

  public void setCars(List<Car> cars) {
    this.cars = cars;
  }
}
