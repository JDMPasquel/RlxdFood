package co.edu.unicauca.userservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.userservice.domain.entity.UserClient;
import co.edu.unicauca.userservice.domain.service.IClientService;
import co.edu.unicauca.userservice.infra.ClientProxy;
import co.edu.unicauca.userservice.utilities.AgeValidator;

@RestController
@RequestMapping("/api/clients")
public class ClientUserController {

    @Autowired
    private IClientService service = new ClientProxy();

    @PostMapping
    public ResponseEntity<?> create(@RequestBody UserClient newClient){

        if(newClient.equals(null) || newClient.getName() == null || newClient.getBirthDate() == null || newClient.getEmail() == null || newClient.getPassword() == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Fields uncompleted");
        }

        if(AgeValidator.greaterThanAge(newClient.getBirthDate(), 18)){
            List<UserClient> tmpClients = service.findByName(newClient.getName());

            if(tmpClients.isEmpty()){
                return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.save(newClient));
            }

            return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).build();
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Only people greater than the legal adult age is accepted");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable(value = "id") Long id){
        Optional<UserClient> tmpClients = service.findById(id);

        if(tmpClients.isPresent()){
           service.deleteById(id);
           return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
