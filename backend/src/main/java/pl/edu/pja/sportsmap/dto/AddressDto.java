package pl.edu.pja.sportsmap.dto;

public record AddressDto(
        String street,
        String postalCode,
        String buildingNumber,
        String apartmentNumber,
        String city
) {
}
