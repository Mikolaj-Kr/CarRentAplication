<#include "navbar.ftlh">
<form action="/service-edit" method="post" id="form-registration"
      class="col-md-3"
      style="margin-left: auto; margin-right: auto; margin-top: 10px; background-color: #D6D7D7"
      role="form">
  <div class="row">
    <div class="col-md-12">
        ${service.mileage}
      <input id="mileage" name="mileage" type="number" class="form-control" value="${service.mileage}" placeholder="przebieg">
    </div>
    <div class="col-md-12">
      <input id="fixes" name="fixes" type="text" class="form-control" value="${service.fixes}" placeholder="naprawy">
    </div>
  </div>
  <div class="row">
    <div class="col-md-12">
     <button type="submit" name="car-service" value="${service.id}" id="car-service" class="btn btn-primary">Zmień</button>
    </div>
  </div>
</form>
<#include "footer.ftlh">