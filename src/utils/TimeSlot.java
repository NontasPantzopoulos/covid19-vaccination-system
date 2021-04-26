package utils;

import java.util.Arrays;
import java.util.Date;

import model.Randevu;

public class TimeSlot {
	private Date date;
	private Randevu[] randevus = new Randevu[5];
	private int randevusCounter = 0;
	
	//Constuctor
	public TimeSlot(Date date) {
		this.date = date;
	}

	//Method
	public void addRandevu(Randevu r) {
		if(randevusCounter>5) {
			System.out.println("Cannot insert Randevu:"+r.toString());
			return;
		}
		this.randevus[randevusCounter]=r;
		randevusCounter++;
	}
	
	//Getters and Setters
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Randevu[] getRandevus() {
		return randevus;
	}

	public void setRandevus(Randevu[] randevus) {
		this.randevus = randevus;
	}


}
