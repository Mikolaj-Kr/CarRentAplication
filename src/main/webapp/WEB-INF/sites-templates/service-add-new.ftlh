<#include "navbar.ftlh">
<form action="/service-add" method="post" id="form-registration"
      class="col-md-6"
      style="margin-left: auto; margin-right: auto; margin-top: 10px; background-color: #D6D7D7"
      role="form">
    <div class="row" style="background-color: #D6D7D7; min-height: 700px">
      <div class="col-md-3">
      <input id="mileage" name="mileage" type="number" class="form-control" placeholder="przebieg">
      </div>
        <div class="col-md-3">
      <button type="submit" id="car-service" class="btn btn-primary">Dodaj</button>
        </div>
    </div>
</form>
<#include "footer.ftlh">