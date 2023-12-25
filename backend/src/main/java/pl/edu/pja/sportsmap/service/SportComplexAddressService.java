package pl.edu.pja.sportsmap.service;

import pl.edu.pja.sportsmap.persistence.dao.AddressRepository;

public class SportComplexAddressService {
    private final AddressRepository addressRepository;

    public SportComplexAddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }
}
