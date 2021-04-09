package site.danielcirilo.springbboot.backend.apirest.f1.parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.logging.Logger;
import java.text.ParseException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import site.danielcirilo.springbboot.backend.apirest.f1.models.entity.Driver;
import site.danielcirilo.springbboot.backend.apirest.f1.models.entity.Race;
import site.danielcirilo.springbboot.backend.apirest.f1.utils.Lib;


/**
 * Esta clase se encarga se parsear el json a objetos java, existen maneras mas simples de parsear de json a java, esta
 * es la manera que me han enseñado.
 * @author dcirilol
 *
 */
public class Parser {
	/*ArrayList para ir almacenando los drivers que vamos obteniendo del json*/
	private ArrayList<Driver> drivers;
	/*ArrayList para ir almacenando las races que vamos obteniendo del json*/
	private ArrayList<Race> races;
	/*Declaramos un buffereader para ir obteni*/
	private BufferedReader br;
	
	/**
	 * Constructor sin parametros, cada ves que instanciamos un objeto invoca inmediantamente al metodo de parser
	 */
	public Parser() {
		if(parse()) {
			parse();
		}else {
			System.err.println("error al parsear");
		}
	}

	public boolean parse() {
		drivers = new ArrayList<>();
		boolean parsed = false;
		String json = " ";

		try {

			br = new BufferedReader(new FileReader(
					"C:\\Cursos\\Spring5\\workspace\\Spring-boot-backend-apirest-f1\\src\\main\\resources\\static\\data.json"));

			String linea = "";
			while ((linea = br.readLine()) != null) {
				json += linea;
			}
			//Una vez ya tenemos los JSON de cada archivo procedemos a parsearlo
            //Cargamos los drivers
			JSONArray jsonArray = new JSONArray(json);
			// drivers = new Driver[jsonArray.length()];
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonDriversObject = jsonArray.getJSONObject(i);
				String id = jsonDriversObject.getString("_id");
				String picture = jsonDriversObject.getString("picture");
				int age = jsonDriversObject.getInt("age");
				String driverName = jsonDriversObject.getString("name");
				String driverTeam = jsonDriversObject.getString("team");
				JSONArray jsonArrayRaces = jsonDriversObject.getJSONArray("races");
				races = new ArrayList<>();
				long timeInMillis = 0;
				 //Cargamos las carreras que tiene cada driver
				for (int j = 0; j < jsonArrayRaces.length(); j++) {
					JSONObject jsonRaces = jsonArrayRaces.getJSONObject(j);
					String raceName = jsonRaces.getString("name");
					String time = jsonRaces.getString("time");
					//Invocamos a la libreria que parsea el tiempo de String a date y hacemos un getTime
					//Para obtener los milisegundos
					timeInMillis = Lib.timeParse(time).getTime();
					//Añadimos las races y las ordenamos
					races.add(new Race(raceName, time,j+1,timeInMillis));
					Collections.sort(races);

				}
				//Anadimos los drivers
				drivers.add(new Driver(id, picture, age, driverName, driverTeam, races, timeInMillis));
				Collections.sort(drivers);
				

			}
			
			//Si hemos llegado hasta aquí, podemos asegurar que los documentos json han sido parseados
			parsed = true;
			br.close();
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return parsed;

	}


	/**
	 * Hacemos un get para obtener los drivers ya parseados
	 * @return nos retorna todos los drivers con sus races
	 */
	public ArrayList<Driver> getDrivers() {
		return drivers;
	}

	public void setDrivers(ArrayList<Driver> drivers) {
		this.drivers = drivers;
	}
	
	/**
	 * Obtenemos todas races del piloto
	 * @returnos retorna las races
	 */
	public ArrayList<Race> getRaces() {
		return races;
	}

	public void setBr(BufferedReader br) {
		this.br = br;
	}

}
