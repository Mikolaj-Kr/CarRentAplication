<#include "navbar.ftlh">

<form action="/reservations" method="post" id="form-reservation" class="col-md-4 rounded "
      style="margin-left: auto; margin-right: auto; margin-top: 10px; background-color: #D6D7D7">
  <header class="card-header">
    <h1 style="text-align: center;"> Rezerwacje online</h1>
  </header>
  <br/>

  <div class="row text-center">
    <div class="col-md-12 text-center">
      <h6>Miejsce wynajmu: </h6>
      <select style="width: 80%; font-size: 20px; text-align-last:center; " name="departmentStart">
          <#list departments as department>
              <#if city??>
                  <#if city == department.city>
                    <option selected value="${department.city}">${department.city}</option>
                  <#else>
                    <option value="${department.city}">${department.city}</option>
                  </#if>
              <#else>
                <option value="${department.city}">${department.city}</option>
              </#if>
          </#list>
      </select>
    </div>
  </div>
  <br/><br/>
  <div class="row text-center">
    <div class="col-md-6">
      <label>Data odbioru auta: </label>
      <input id="startDate" name="startDate" type="date" class="form-control" required>
    </div>
    <div class="col-md-6">
      <label>Godzina odbioru auta: </label>
      <input id="startHour" name="startHour" type="time" step="900" class="form-control" required>
    </div>
  </div>
  <br/><br/>
  <div class="row text-center">
    <div class="col-md-6">
      <label>Data zwrotu auta: </label>
      <input id="backDate" name="backDate" type="date" class="form-control" required>
    </div>
    <div class="col-md-6">
      <label>Godzina zwrotu auta: </label>
      <input id="backHour" name="backHour" type="time" step="900" class="form-control" required>
    </div>
  </div>
  <br/><br/>
  <div class="row text-center">
    <div class="col-md-12">
        <#if type == "Client">
          <button class="btn btn-success" type="submit" style="margin-bottom: 20px; width:70%;">
            Dalej
          </button>
        <#elseif type == "Guest">
          <a class="btn btn-primary" href="#" style="margin-bottom: 20px; width:70%;"
             data-toggle="modal" data-target="#loginModal">Zaloguj się, aby zarezerwować</a>
        </#if>
    </div>
  </div>
</form>
<#include "footer.ftlh">