package site.danielcirilo.springbboot.backend.apirest.f1.parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.text.ParseException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import site.danielcirilo.springbboot.backend.apirest.f1.models.entity.Driver;
import site.danielcirilo.springbboot.backend.apirest.f1.models.entity.Race;

public class Parser {
	private ArrayList<Driver> drivers;
	private ArrayList<Race> races;
	private BufferedReader br;

	public Parser() {
		parse();
	}

	public boolean parse() {
		drivers = new ArrayList<>();
		boolean parsed = false;
		String json = " ";

		try {

			br = new BufferedReader(new FileReader(
					"C:\\Cursos\\Spring5\\workspace\\Spring-boot-backend-apirest-f1\\src\\main\\resources\\static\\drivers.json"));

			String linea = "";
			while ((linea = br.readLine()) != null) {
				json += linea;
			}

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
				// long totalDriverTime = 0;
				long timeInMillis = 0;
				for (int j = 0; j < jsonArrayRaces.length(); j++) {
					JSONObject jsonRaces = jsonArrayRaces.getJSONObject(j);
					String raceName = jsonRaces.getString("name");
					String time = jsonRaces.getString("time");
					
					timeInMillis = timeParse(time).getTime();
					races.add(new Race(raceName, time, (j + 1), timeInMillis));
					Collections.sort(races);

				}

				drivers.add(new Driver(id, picture, age, driverName, driverTeam, races, timeInMillis));
				Collections.sort(drivers);

			}

			parsed = true;
			br.close();
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		return parsed;

	}

	public Date timeParse(String time) {
		SimpleDateFormat formato = new SimpleDateFormat("HH:mm:ss.SS");
		Date timeFormat = null;
		try {
			timeFormat = formato.parse(time);
		} catch (ParseException ex) {
			System.out.println(ex);
		}
		return timeFormat;
	}

	public ArrayList<Driver> finAllDriver() {
		return drivers;
	}

	public void setDrivers(ArrayList<Driver> drivers) {
		this.drivers = drivers;
	}

	public ArrayList<Race> getRaces() {
		return races;
	}

	public void setRaces(ArrayList<Race> races) {
		this.races = races;
	}

	public BufferedReader getBr() {
		return br;
	}

	public void setBr(BufferedReader br) {
		this.br = br;
	}
	
	/**
	public  Long milisegundos2tiempo(long timeInMillis){
	    int mili = (int) (timeInMillis%1000); timeInMillis -= mili; timeInMillis /= 1000;
	    int seconds = (int) (timeInMillis%60); timeInMillis -= seconds; timeInMillis /= 60;
	    int mins = (int) (timeInMillis%60); timeInMillis -= mins; timeInMillis /= 60;
	    int hours = (int) timeInMillis%24;
	    return (long) (hours*1000*100*100 + mins*1000*100 + seconds*1000 + mili);
	}
	 **/
}
