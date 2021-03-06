package rest;

import dao.DepartmentDaoBean;
import dao.WorkerDaoBean;
import entity.Client;
import entity.Worker;
import javax.ejb.EJB;
import javax.ws.rs.PATCH;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import service.ClientService;
import service.PositionService;

@Path("/clients")
public class PrivilegeClientsController {

  @EJB
  ClientService clientService;

  @EJB
  PositionService positionService;

  @EJB
  WorkerDaoBean workerDaoBean;

  @EJB
  DepartmentDaoBean departmentDaoBean;


  @PATCH
  @Path("/{permission}/{id}")
  public Response giveWorkerPermissions(@PathParam("id") String idParam,
      @PathParam("permission") String permission) {
    Long id = Long.valueOf(idParam);

    Client client = clientService.findClientById(id);
    Worker worker = new Worker();
    worker.setFullName(client.getNameAndSurname());
    worker.setPesel(client.getPesel());
    worker.setPhoneNumber(client.getPhoneNumber());
    worker.setPassword(client.getPassword());
    worker.setEmail(client.getEmail());
    worker.setDepartment(departmentDaoBean.findWarszawaDepartment());
    if (permission.equals("giveManager")) {
      worker.setPosition(positionService.findMenagerPosition());
    }
    if (permission.equals("giveWorker")) {
      worker.setPosition(positionService.findWorkerPosition());
    }
    if (permission.equals("giveCoordinator")) {
      worker.setPosition(positionService.findCoordinatorPosition());
    }
    workerDaoBean.saveWorker(worker);
    clientService.deleteClientById(id);
    return Response.ok().build();
  }

  @PATCH
  @Path("/deleteProfile/{id}")
  public Response deleteClient(@PathParam("id") String idParam) {
    Long id = Long.valueOf(idParam);
    clientService.deleteClientById(id);
    return Response.ok().build();
  }
}
