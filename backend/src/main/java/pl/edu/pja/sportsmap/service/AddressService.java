package pl.edu.pja.sportsmap.service;

import org.springframework.stereotype.Service;
import pl.edu.pja.sportsmap.dto.AddressDto;
import pl.edu.pja.sportsmap.persistence.dao.AddressRepository;
import pl.edu.pja.sportsmap.persistence.model.Address;

@Service
public class AddressService {
    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address addAddress(AddressDto addressDto) {
        Address address = convertToEntity(addressDto);
        return addressRepository.saveAndFlush(address);
    }

    private Address convertToEntity(AddressDto addressDto) {
        return Address.builder()
                .street(addressDto.street())
                .postalCode(addressDto.postalCode())
                .buildingNumber(addressDto.buildingNumber())
                .apartmentNumber(addressDto.apartmentNumber())
                .city(addressDto.city())
                .build();
    }
}
