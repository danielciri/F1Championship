package site.danielcirilo.springbboot.backend.apirest.f1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import site.danielcirilo.springbboot.backend.apirest.f1.models.entity.Driver;
import site.danielcirilo.springbboot.backend.apirest.f1.models.entity.Race;
import site.danielcirilo.springbboot.backend.apirest.f1.parser.Parser;


@Component
public class DriverServiceImpl implements IDriverService {
	Parser parser = new Parser();

	@Override
	public List<Driver> ranking() {
		ArrayList<Driver> aux = new ArrayList<>();

		for (int i = 0; i < parser.finAllDriver().size(); i++) {

			aux.add(new Driver(parser.finAllDriver().get(i).getName(), parser.finAllDriver().get(i).getTeamName(),
					(i + 1), parser.finAllDriver().get(i).getPicture()));

		}

		return aux;
	}

	@Override
	public Driver findOne(String driver) {
		Driver driver3 = null;

		for (int i = 0; i < parser.finAllDriver().size(); i++) {

			if (parser.finAllDriver().get(i).getId().equalsIgnoreCase(driver)) {
				driver3 = new Driver(parser.finAllDriver().get(i).getPicture(), parser.finAllDriver().get(i).getName(),
						parser.finAllDriver().get(i).getAge(), parser.finAllDriver().get(i).getTeamName(), (i + 1),
						(ArrayList<Race>) parser.finAllDriver().get(i).totalRaces());
			}

		}

		return driver3;
	}

}
