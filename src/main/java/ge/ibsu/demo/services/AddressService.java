package ge.ibsu.demo.services;

import ge.ibsu.demo.dto.AddAddress;
import ge.ibsu.demo.entities.Address;
import ge.ibsu.demo.entities.City;
import ge.ibsu.demo.repositories.AddressRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    @Transactional
    public Address getAddress(AddAddress addAddress) {
        Address address = addressRepository.findOneByAddress(addAddress.getAddress());
        if (address != null) {
            return  address;
        }
        address = new Address();
        address.setAddress(addAddress.getAddress());
        address.setPostalCode(addAddress.getPostalCode());

        return addressRepository.save(address);
    }
    @Autowired
    private CityService cityService;

    public Address addAddress(Address address, Long cityId) {
        City city = cityService.getCityById(cityId);
        address.setCity(city);
        return addressRepository.save(address);
    }
}
