package site.danielcirilo.springbboot.backend.apirest.f1.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

import site.danielcirilo.springbboot.backend.apirest.f1.models.entity.Driver;
import site.danielcirilo.springbboot.backend.apirest.f1.models.entity.Race;
import site.danielcirilo.springbboot.backend.apirest.f1.parser.Parser;

@Component
public class DriverServiceImpl implements IDriverService {
	Parser parser = new Parser();

	/**
	 * Metodo implementado para obtener todos los drivers ordenados en el ranking
	 * global
	 */
	@Override
	public List<Driver> ranking() {

		ArrayList<Driver> aux = new ArrayList<>();
		// Ordenamos los drivers
		Collections.sort(parser.getDrivers());
		for (int i = 0; i < parser.getDrivers().size(); i++) {
			aux.add(new Driver(parser.getDrivers().get(i).getName(), parser.getDrivers().get(i).getTeamName(), (i + 1),
					parser.getDrivers().get(i).getPicture()));

		}
		return aux;
	}

	/**
	 * Metodo implementado para obtener el driver por el id nos devolvera el driver
	 * seleccionado
	 */
	@Override
	public Driver findOne(String idDriver) {
		Driver driver = null;
		for (int i = 0; i < parser.getDrivers().size(); i++) {
			if (parser.getDrivers().get(i).getId().equalsIgnoreCase(idDriver)) {
				driver = new Driver(parser.getDrivers().get(i).getPicture(), parser.getDrivers().get(i).getName(),
						parser.getDrivers().get(i).getAge(), parser.getDrivers().get(i).getTeamName(), (i + 1),
						(ArrayList<Race>) parser.getDrivers().get(i).getRaces());
			}

		}

		return driver;
	}

}
