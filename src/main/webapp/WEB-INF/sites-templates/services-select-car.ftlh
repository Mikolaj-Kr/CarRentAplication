<#include "navbar.ftlh">
<div class="container-fluid" style="background-color: #D6D7D7; min-height: 700px">
  <div class="row">
    <h1 style="text-align: center;margin-top: 30px; margin-left: auto; margin-right: auto;">
      Wybierz auto:
    </h1>
    <div class="table-responsive">
      <table class="table table-dark table-striped table-bordered table-hover table-fixed "
             style="text-align: center; margin-top: 30px">
        <thead>
        <tr style="background-color: #052F09">
          <th scope="col">Rejestracja</th>
          <th scope="col">Marka</th>
          <th scope="col">Model</th>
        </tr>
        </thead>
        <tbody>
        <#list cars as car>
          <tr onclick="singleService(${car.id})">
            <th scope="row"><#if car.registrationNumber??>  ${car.registrationNumber} </#if> </th>
            <td> ${car.brandDto.name} </td>
            <td> ${car.modelDto.name} </td>
          </tr>
        </#list>
      </table>
    </div>
  </div>
</div>
<#include "footer.ftlh">