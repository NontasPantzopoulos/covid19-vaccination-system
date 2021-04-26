package model;

import java.util.Date;

public class Randevu {
	private int code;
	private int codeCounter =0;
	private InsuredPerson insuredPerson;
	private VaccinationCenter vc;
	private Doctor doctor;
	private Date date;
	
	//Constructors
	public Randevu(int code, InsuredPerson insuredPerson,VaccinationCenter vc, Doctor doctor) {
		this.code = code;
		this.insuredPerson = insuredPerson;
		this.vc=vc;
		this.doctor = doctor;
	}
	
	public Randevu(InsuredPerson insuredPerson, VaccinationCenter vc, Doctor doctor) {
		this.insuredPerson = insuredPerson;
		this.doctor = doctor;
		this.vc=vc;
	}
	
	
	//Getters and Setters
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getCodeCounter() {
		return codeCounter;
	}

	public void setCodeCounter(int codeCounter) {
		this.codeCounter = codeCounter;
	}

	public InsuredPerson getInsuredPerson() {
		return insuredPerson;
	}

	public void setInsuredPerson(InsuredPerson insuredPerson) {
		this.insuredPerson = insuredPerson;
	}


	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public VaccinationCenter getVc() {
		return vc;
	}

	public void setVc(VaccinationCenter vc) {
		this.vc = vc;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	


	
	
	
	

}
