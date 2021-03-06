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
        name = "Section.findAll",
        query = "SELECT s FROM Section s"
    )
})
@Entity
@Table(name = "section")
public class Section {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "section_id")
  Long id;

  @Column(name = "name")
  String name;

  @Column(name = "price")
  Long price;

  @OneToMany(mappedBy = "section")
  List<Model> models = new ArrayList<>();

  public Section() {
  }

  public Section(String name, Long price) {
    this.name = name;
    this.price = price;
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

  public Long getPrice() {
    return price;
  }

  public void setPrice(Long price) {
    this.price = price;
  }

  public List<Model> getModels() {
    return models;
  }

  public void setModels(List<Model> models) {
    this.models = models;
  }
}
