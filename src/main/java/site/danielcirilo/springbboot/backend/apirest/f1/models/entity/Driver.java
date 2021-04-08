package site.danielcirilo.springbboot.backend.apirest.f1.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Driver implements Serializable, Comparable<Driver> {


	private static final long serialVersionUID = 1L;

	private String picture;

	private int age;

	private String name;

	private String teamName;

	private List<Race> races;

	private String id;

	private long milisegundos;

	private int globalPosition;

	public Driver(String id, String picture, int age, String name, String teamName, ArrayList<Race> races,
			long milisegundos) {

		this.id = id;
		this.picture = picture;
		this.age = age;
		this.name = name;
		this.teamName = teamName;
		this.races = races;
		this.milisegundos = milisegundos;

	}

	public Driver(String picture, String name, int age, String teamName, int globalPosition, ArrayList<Race> races) {
		this.picture = picture;
		this.age = age;
		this.name = name;
		this.teamName = teamName;
		this.globalPosition = globalPosition;
		this.races = races;

	}



	public Driver(String name, int age, String teamName, int globalPosition, ArrayList<Race> races, long milisegundos) {
		this.milisegundos = milisegundos;
		this.age = age;
		this.name = name;
		this.teamName = teamName;
		this.globalPosition = globalPosition;
		this.races = races;

	}


	public Driver(String name, String teamName, int globalPosition, String picture) {
		this.name = name;
		this.teamName = teamName;
		this.globalPosition = globalPosition;
		this.picture = picture;
	}

	public Driver(long milisegundos) {
		this.milisegundos = milisegundos;
	}

	public Driver(ArrayList<Race> races) {
		this.races = races;
	}

	public long getMilisegundos() {
		return milisegundos;
	}

	public void setMilisegundos(Long milisegundos) {
		this.milisegundos = milisegundos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Race> getRaces() {
		return races;
	}

	public void setRaces(ArrayList<Race> races) {
		this.races = races;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setRaces(List<Race> races) {
		this.races = races;
	}

	public ArrayList<Race> totalRaces() {

		return (ArrayList<Race>) races;

	}

	public int getGlobalPosition() {
		return globalPosition;
	}

	public void setGlobalPosition(int globalPosition) {
		this.globalPosition = globalPosition;
	}

	@Override
	public String toString() {
		return "Driver [picture=" + picture + ", age=" + age + ", name=" + name + ", teamName=" + teamName
				+ races.toString() + " milisegundos totales" + "  ]" + "  Miliseugnod solo" + milisegundos + '\n';
	}

	@Override
	public int compareTo(Driver o) {
		if (milisegundos < o.milisegundos) {

			return -1;
		}
		if (milisegundos > o.milisegundos) {
			return 1;
		}
		return 0;
	}

}
