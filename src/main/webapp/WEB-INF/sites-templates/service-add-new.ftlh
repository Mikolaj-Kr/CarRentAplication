<#include "navbar.ftlh">
<form action="/service-add" method="post" id="form-registration"
      class="col-md-3"
      style="margin-left: auto; margin-right: auto; margin-top: 10px; background-color: #D6D7D7"
      role="form">
  <div class="row">
    <div class="col-md-12">
      <input id="mileage" name="mileage" type="number" class="form-control" placeholder="przebieg">
    </div>
    <div class="col-md-12">
      <input id="fixes" name="fixes" type="text" class="form-control" placeholder="naprawy">
    </div>
  </div>
  <div class="row">
    <div class="col-md-12">
     <a href="/services"><button type="submit" id="car-service" class="btn btn-primary">Dodaj</button></a>
    </div>
  </div>
</form>
<#include "footer.ftlh">