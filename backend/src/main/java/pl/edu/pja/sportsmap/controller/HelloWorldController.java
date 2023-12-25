package pl.edu.pja.sportsmap.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pja.sportsmap.persistence.model.Address;
import pl.edu.pja.sportsmap.persistence.dao.AddressRepository;

import java.util.List;

@RestController
public class HelloWorldController {

    private final AddressRepository addressRepository;

    public HelloWorldController(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @GetMapping("hello")
    public ResponseEntity<List<Address>> getAllAddresses() {
        List<Address> addresses = addressRepository.findAll();
        return ResponseEntity.ok().body(addresses);
    }
}
