package model;

import java.util.Arrays;

import utils.Day;

public class VaccinationCenter {
	private int code;
	private String title;
	private String city;
	private Doctor[] doctors = new Doctor[5];
	private int doctorsCounter = 0;
	private Day[] days =new Day[7];
	//[Day][TimeSlot][Doctor]
	private Randevu[][][] randevus = new Randevu[7][4][5];
	
	
	//Constructor
	public VaccinationCenter(int code, String title, String city) {
		this.code = code;
		this.title = title;
		this.city = city;
	}
	
	
	public VaccinationCenter(int code, String title, String city, Day[] days) {
		this.code = code;
		this.title = title;
		this.city = city;
		this.days = days;
	}


	//Functions
	public void addDoctor(Doctor d) {
		if(doctorsCounter>5) {
			System.out.println("Cannot insert Doctor: "+d.toString());
			return;
		}
		this.doctors[doctorsCounter]=d;
		doctorsCounter++;
	}
	
	public void addRantevu(Randevu r,int dayPos,int timeSlotPos,int doctorPos) {
	
		if(dayPos>7 || timeSlotPos>4 || doctorPos>5) {
			System.out.println("Could not insert randevu to this Vaccination Center "+r.toString());
			return;
		}
		//this.randevus[dayPos][timeSlotPos][doctorPos] = r;
		this.days[dayPos].getTimeSlots()[timeSlotPos].addRandevu(r);
	}
	
	//Getters and Setters
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Randevu[][][] getRandevus() {
		return randevus;
	}

	public void setRandevus(Randevu[][][] randevus) {
		this.randevus = randevus;
	}

	public Doctor[] getDoctors() {
		return doctors;
	}

	public void setDoctors(Doctor[] doctors) {
		this.doctors = doctors;
	}

	public Day[] getDays() {
		return days;
	}

	public void setDays(Day[] days) {
		this.days = days;
	}


	public int getDoctorsCounter() {
		return doctorsCounter;
	}


	public void setDoctorsCounter(int doctorsCounter) {
		this.doctorsCounter = doctorsCounter;
	}

	
	
	
	

}
