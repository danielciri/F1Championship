package site.danielcirilo.springbboot.backend.apirest.f1.models.entity;

import java.io.Serializable;

public class Race implements Serializable, Comparable<Race> {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String name;

	private String time;

	private int posicionDriver;

	private long milisegundos;

	public Race(String name, String time,int posicionDriver) {
		this.name = name;
		this.time = time;
		this.posicionDriver = posicionDriver;

	}

	public Race(String name, String time, int posicionDriver, long milisegundos) {

		this.name = name;
		this.time = time;
		this.posicionDriver = posicionDriver;
		this.milisegundos = milisegundos;
	}

	public Race(String name, String time, long milisegundos) {

		this.name = name;
		this.time = time;

		this.milisegundos = milisegundos;
	}



	public Race(int posicionDriver) {

		this.posicionDriver = posicionDriver;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getPosicionDriver() {
		return posicionDriver;
	}

	public void setPosicionDriver(int posicionDriver) {
		this.posicionDriver = posicionDriver;
	}

	public long getMilisegundos() {
		return milisegundos;
	}

	public void setMilisegundos(long milisegundos) {
		this.milisegundos = milisegundos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public int compareTo(Race o) {
		if (milisegundos < o.milisegundos) {
			return -1;
		}
		if (milisegundos > o.milisegundos) {
			return 1;
		}
		return 0;
	}

	@Override
	public String toString() {
		return "Race [id=" + id + ", name=" + name + ", time=" + time + ", posicionDriver=" + posicionDriver
				+ ", milisegundos=" + milisegundos + "]";
	}

}
