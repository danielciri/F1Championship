package site.danielcirilo.springbboot.backend.apirest.f1.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
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
		Driver driver = null;
		ArrayList<Race> auxArrayRace = null;
		for (int j = 0; j < parser.getDrivers().size(); j++) {
			driver = parser.getDrivers().get(j);
			auxArrayRace = new ArrayList<>();
			ArrayList<Race> races = (ArrayList<Race>) driver.getRaces();
			for (int i = 0; i < races.size(); i++) {
				if (races.get(i).getName().equalsIgnoreCase(nameRace)) {
					auxArrayRace.add(new Race(races.get(i).getName(), races.get(i).getTime(), races.get(i).getMilisegundos()));
					for (int k = 0; k < auxArrayRace.size(); k++) {
						drivers.add(new Driver(driver.getName(), driver.getAge(), driver.getTeamName(), j + 1,
								auxArrayRace, auxArrayRace.get(k).getMilisegundos()));
						

					}
				}
			}
		}
		Collections.sort(drivers);
		
		for (int i = 0; i < drivers.size(); i++) {
			ArrayList<Race> posiciones = new ArrayList<>();
			for (int j = 0; j < auxArrayRace.size(); j++) {
				posiciones.add((new Race(auxArrayRace.get(j).getName(), auxArrayRace.get(j).getTime(),i+1,auxArrayRace.get(j).getMilisegundos())));
				
			}
		
			drivers.get(i).setRaces(posiciones);
		}
			
	
		
	
		return drivers;
	}


	
	
}
