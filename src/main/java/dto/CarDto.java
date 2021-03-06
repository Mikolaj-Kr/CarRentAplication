package dto;

import java.util.Objects;

public class CarDto {

  private Long id;
  private String registrationNumber;
  private BrandDto brandDto;
  private ModelDto modelDto;
  private DepartmentDto departmentDto;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getRegistrationNumber() {
    return registrationNumber;
  }

  public void setRegistrationNumber(String registrationNumber) {
    this.registrationNumber = registrationNumber;
  }

  public BrandDto getBrandDto() {
    return brandDto;
  }

  public void setBrandDto(BrandDto brandDto) {
    this.brandDto = brandDto;
  }

  public ModelDto getModelDto() {
    return modelDto;
  }

  public void setModelDto(ModelDto modelDto) {
    this.modelDto = modelDto;
  }

  public DepartmentDto getDepartmentDto() {
    return departmentDto;
  }

  public void setDepartmentDto(DepartmentDto departmentDto) {
    this.departmentDto = departmentDto;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof CarDto)) {
      return false;
    }
    CarDto carDto = (CarDto) o;
    return Objects.equals(getId(), carDto.getId()) &&
        Objects.equals(getRegistrationNumber(), carDto.getRegistrationNumber()) &&
        Objects.equals(getBrandDto(), carDto.getBrandDto()) &&
        Objects.equals(getModelDto(), carDto.getModelDto()) &&
        Objects.equals(getDepartmentDto(), carDto.getDepartmentDto());
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(getId(), getRegistrationNumber(), getBrandDto(), getModelDto(), getDepartmentDto());
  }
}
