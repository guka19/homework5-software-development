package ge.ibsu.demo.controllers;

import ge.ibsu.demo.entities.Address;
import ge.ibsu.demo.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    @Autowired
    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = {"application/json"})
    public List<Address> getAll() {
        return addressService.getAll();
    }

    @PostMapping("/{cityId}")
    public Address addAddress(@RequestBody Address address, @PathVariable Long cityId) {
        return addressService.addAddress(address, cityId);
    }
}
