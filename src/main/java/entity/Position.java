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
        name = "Position.findWorker",
        query = "SELECT p FROM Position p WHERE p.name LIKE 'Pracownik'"
    ),
    @NamedQuery(
        name = "Position.findAdmin",
        query = "SELECT p FROM Position p WHERE p.name LIKE 'Admin'"
    ),
    @NamedQuery(
        name = "Position.findMenager",
        query = "SELECT p FROM Position p WHERE p.name LIKE 'Menadżer'"
    ),
    @NamedQuery(
        name = "Position.findCoordinator",
        query = "SELECT p FROM Position p WHERE p.name LIKE 'Koordynator'"
    ),

})

@Entity
@Table(name = "position")
public class Position {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "position_id")
  Long id;

  @Column(name = "name")
  String name;

  @OneToMany(mappedBy = "position")
  List<Worker> workers = new ArrayList<>();

  public Position() {
  }

  public Position(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Worker> getWorkers() {
    return workers;
  }

  public void setWorkers(List<Worker> workers) {
    this.workers = workers;
  }
}
