package model;

import java.util.Arrays;

public class Doctor {
	private String aMhtrwou;
	private String name;
	private Randevu[] randevus = new Randevu[28];
	private int randevusCounter = 0;
	
	//Constructor
	public Doctor(String aMhtrwou, String name) {
		this.aMhtrwou = aMhtrwou;
		this.name = name;
	}
	
	public void addRandevu(Randevu r) {
		if(randevusCounter>28) {
			return;
		}
		this.randevus[randevusCounter] = r;
		randevusCounter++;
	}
	
	
	//Getters and Setters
	public String getaMhtrwou() {
		return aMhtrwou;
	}

	public void setaMhtrwou(String aMhtrwou) {
		this.aMhtrwou = aMhtrwou;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Randevu[] getRandevus() {
		return randevus;
	}

	public void setRandevus(Randevu[] randevus) {
		this.randevus = randevus;
	}

	public int getRandevusCounter() {
		return randevusCounter;
	}

	public void setRandevusCounter(int randevusCounter) {
		this.randevusCounter = randevusCounter;
	}

	



	

	
	
	
	
	
	
	

}
