package site.danielcirilo.springbboot.backend.apirest.f1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import site.danielcirilo.springbboot.backend.apirest.f1.models.entity.Driver;
import site.danielcirilo.springbboot.backend.apirest.f1.models.entity.Race;
import site.danielcirilo.springbboot.backend.apirest.f1.parser.Parser;

@Component
public class RaceServiceImpl implements IRaceService {
	Parser parser = new Parser();
	@Override
	public List<Race> findAll() {

		return parser.getRaces();
	}

	@Override
	public List<Driver> findOne(String nameRace) {
		ArrayList<Driver> drivers = new ArrayList<>();
		
		Driver driver;
		for (Driver driverAux : parser.finAllDriver()) {
			driver = driverAux;
			ArrayList<Race> auxArrayRace = new ArrayList<>();
			ArrayList<Race> races = (ArrayList<Race>) driver.getRaces();
			for(Race race: races) {

				if(race.getName().equalsIgnoreCase(nameRace)) {
					auxArrayRace.add(race);
					driver.setRaces(auxArrayRace);
					drivers.add(driver);
				}
		
			}
		
			
		}
		
		
		return drivers;
	}


	
	
}
