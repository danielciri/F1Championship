package site.danielcirilo.springbboot.backend.apirest.f1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import site.danielcirilo.springbboot.backend.apirest.f1.models.entity.Driver;
import site.danielcirilo.springbboot.backend.apirest.f1.service.IDriverService;
import site.danielcirilo.springbboot.backend.apirest.f1.service.IRaceService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class DriverController {
	
	@Autowired
	IDriverService driverService; 
	
	@Autowired
	IRaceService raceService;
	
	@GetMapping("/ranking")
	public List<Driver> driver() {
		return driverService.ranking();
	}
	
	@GetMapping("/driver/{id}")
	public Driver findById(@PathVariable(value = "id") String id) {
		return driverService.findOne(id);
	}
	

	@GetMapping("/ranking/{id}")
	public List<Driver> findOne(@PathVariable(value = "id") String id) {
		return  raceService.findOne(id);
	}
	

	
	
}
