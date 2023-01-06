package br.com.igor.port.MyProject.resource;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.igor.port.MyProject.entities.Client;
import br.com.igor.port.MyProject.repository.ClientRepository;

@RestController
@RequestMapping(value = "/Client")
public class ClientResource {

    @Autowired
    ClientRepository clientRepository;

    @PostMapping("/ClientCreate")
    public String createClient(Client client) {
        try {
            clientRepository.save(client);
            return "the Client " + client.getName() + " Id " + client.getId() + " was successfully created";

        } catch (Exception e) {
            return "Cannot create Client because need more parameters\n";
        }

    }

    @GetMapping
    public ResponseEntity<List<Client>> findAll() {
        List<Client> clientList = clientRepository.findAll();
        return ResponseEntity.ok().body(clientList);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> searchById(@PathVariable Long id) {
        try {
            Client Client = clientRepository.findById(id).get();
            return ResponseEntity.ok().body(Client);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(id + " Not Found");
        }
    }

    @PutMapping("/update")
    public Object updateClient(
            @RequestParam Long id,
            @RequestParam String name,
            @RequestParam String date,
            @RequestParam String email) {

        try {
            Client Client = clientRepository.findById(id).get();
            Client.setName(name);
            Client.setBirthday(LocalDate.parse(date));
            Client.setEmail(email);
            clientRepository.save(Client);
            return Client;
        } catch (Exception e) {
            e.printStackTrace();
            return "id: " + id + " Cannot update \n" + "STACK\n" + e;
        }
    }

    @DeleteMapping("/delete")
    public Object deleteClient(@RequestParam Long id) {
        try {
            clientRepository.deleteById(id);
            return "Client Deleted";
        } catch (Exception e) {
            return "id: " + id + " Cannot delete because id not Found\n" + "STACK\n" + e;
        }
    }
}
