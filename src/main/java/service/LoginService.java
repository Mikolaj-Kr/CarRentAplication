package service;

import dto.ClientDto;
import dto.WorkerDto;
import entity.Client;
import entity.Worker;
import java.lang.management.OperatingSystemMXBean;
import java.util.Optional;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.swing.text.html.Option;

@Stateless
public class LoginService {

  @EJB
  ClientService clientService;

  @EJB
  WorkerService workerService;

  public boolean isClientInDataBase (String email, String password){
    Optional<Client> client = clientService.findClientByEmail(email);
    if(client.isPresent()) {
      return client.get().getPassword().equals(password);
    }
    return false;
  }

  public boolean isWorkerInDataBase (String email, String password){
    Optional<Worker> worker = workerService.findWorkerByEmail(email);
    if(worker.isPresent()) {
      return worker.get().getPassword().equals(password);
    }
    return false;
  }
}