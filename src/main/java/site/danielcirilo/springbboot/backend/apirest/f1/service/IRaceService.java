package site.danielcirilo.springbboot.backend.apirest.f1.service;

import java.util.List;

import site.danielcirilo.springbboot.backend.apirest.f1.models.entity.Driver;
import site.danielcirilo.springbboot.backend.apirest.f1.models.entity.Race;

public interface IRaceService {
	public List<Race> findAll();
	public List<Driver>  findOne(String id);
}
