package dto;

import java.util.Objects;

public class BrandDto {

  private Long id;
  private String name;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof BrandDto)) {
      return false;
    }
    BrandDto brandDto = (BrandDto) o;
    return Objects.equals(getId(), brandDto.getId()) &&
        Objects.equals(getName(), brandDto.getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getName());
  }
}
