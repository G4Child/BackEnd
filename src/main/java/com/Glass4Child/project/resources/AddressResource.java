package com.Glass4Child.project.resources;
	import com.Glass4Child.project.entities.Address;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

import com.Glass4Child.project.services.AddressService;

    import java.util.List;



	@RestController
	@RequestMapping(value = "/address")
	public class AddressResource {

	    @Autowired
	    private AddressService service;

	    @GetMapping
	    public ResponseEntity<List<Address>> findAll() {

	        List<Address> list = service.findAll();
	        return ResponseEntity.ok().body(list);
	    }

	    @GetMapping(value = "/{id}")
	    public ResponseEntity<Address> findByDocument(@PathVariable Long id) {
			Address obj = service.findById(id);
	        return ResponseEntity.ok().body(obj);
	    }
}
