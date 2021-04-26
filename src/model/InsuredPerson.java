package model;

public class InsuredPerson {
	private long amka;
	private String name;
	private String city;
	private Randevu randevu;
	
	//Constructor
	public InsuredPerson(long amka, String name, String city) {
		this.amka = amka;
		this.name = name;
		this.city = city;
	}
	
	public void addRandevu(Randevu r) {
		this.randevu =r;
	}
	
	//Getters and Setters
	public long getAmka() {
		return amka;
	}

	public void setAmka(long amka) {
		this.amka = amka;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Randevu getRandevu() {
		return randevu;
	}

	public void setRandevu(Randevu randevu) {
		this.randevu = randevu;
	}

	

	

	

	
	
	
}
