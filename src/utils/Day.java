package utils;

import java.util.Arrays;
import java.util.Date;

public class Day {
	private Date date= new Date();
	private TimeSlot[] timeSlots =new TimeSlot[4];
	private int timeSlotsCounter = 0;
	
	//Constructor
	@SuppressWarnings("deprecation")
	public Day(int dayOfMonth) {
		this.date.setDate(dayOfMonth);
		this.timeSlots[0] = new TimeSlot(new Date(date.getYear(),date.getMonth(),dayOfMonth,9,0,0));
		this.timeSlots[1] = new TimeSlot(new Date(date.getYear(),date.getMonth(),dayOfMonth,9,30,0));
		this.timeSlots[2] = new TimeSlot(new Date(date.getYear(),date.getMonth(),dayOfMonth,10,0,0));
		this.timeSlots[3] = new TimeSlot(new Date(date.getYear(),date.getMonth(),dayOfMonth,10,30,0));
	}

	//Getters and Setters
	public TimeSlot[] getTimeSlots() {
		return timeSlots;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setTimeSlots(TimeSlot[] timeSlots) {
		this.timeSlots = timeSlots;
	}

}
