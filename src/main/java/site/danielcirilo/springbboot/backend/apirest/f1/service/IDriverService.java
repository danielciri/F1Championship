package site.danielcirilo.springbboot.backend.apirest.f1.service;

import java.util.List;

import site.danielcirilo.springbboot.backend.apirest.f1.models.entity.Driver;

public interface IDriverService {
	public List<Driver> ranking();
	
	public Driver findOne(String driver);
	
}
