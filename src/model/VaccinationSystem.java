package model;

import java.util.Random;
import java.util.Scanner;

import utils.Day;
import utils.TimeSlot;

public class VaccinationSystem {
	private String name;
	private String url;
	private Day[] days = new Day[7];
	private InsuredPerson[] insuredPersons = new InsuredPerson[100];
	private int insuredPersonsCounter =0;
	private VaccinationCenter[] vaccinationCenters =new VaccinationCenter[10];
	private int vaccinationCentersCounter = 0;
	
	//Constructor
	public VaccinationSystem(String name, String url) {
		this.name = name;
		this.url = url;
	}
	
	
	//Functions
	public void addInsurancedPerson(InsuredPerson p) {
		if(insuredPersonsCounter>100) {
			System.out.println("Cannot insert Insured Person: "+p.toString());
			return;
		}
		this.insuredPersons[insuredPersonsCounter] =p;
		insuredPersonsCounter++;
	}
	
	public void addVaccinationCenter(VaccinationCenter v) {
		if(vaccinationCentersCounter>10) {
			System.out.println("Cannot insert Vaccination Center: "+v.toString());
			return;
		}
		this.vaccinationCenters[vaccinationCentersCounter] = v;
		vaccinationCentersCounter++;
	}
	
	public void addInsuredPerson() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n---EISAGWGH ASFALISMENOY---\n");
		System.out.printf("EISAGETE AMKA: ");
		long amka = sc.nextLong();
		System.out.printf("EISAGETE ONOMA: ");
		String onoma = sc.next();
		System.out.printf("EISAGETE POLH: ");
		String city = sc.next();
		InsuredPerson tempPerson = new InsuredPerson(amka, onoma, city);
		addInsurancedPerson(tempPerson);
	}
	
	public void addEK() {
		Scanner sc = new Scanner(System.in);
		Day[] manualDays = new Day[7];
		manualDays[0]= new Day(22);
		manualDays[1]= new Day(23);
		manualDays[2]= new Day(24);
		manualDays[3]= new Day(25);
		manualDays[4]= new Day(26);
		manualDays[5]= new Day(27);
		manualDays[6]= new Day(28);
		System.out.println("\n---EISAGWGH EMBOLIASTIKOU KENTROU---\n");
		System.out.printf("EISAGETE KWDIKO EK: ");
		int code =sc.nextInt();
		System.out.printf("EISAGETE TITLO: ");
		String title = sc.next();
		System.out.printf("EISAGETE POLH: ");
		String polh = sc.next();
		VaccinationCenter tempVC = new VaccinationCenter(code, title, polh, manualDays);
		
		addVaccinationCenter(tempVC);
	}
	
	public void addDoctor() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n---EISAGWGH IATROY---\n");
		System.out.printf("EISAGETE AM: ");
		String am =sc.next();
		System.out.printf("EISAGETE ONOMA: ");
		String name = sc.next();
		//Dhmiourgia iatrou object
		Doctor tempDoc = new Doctor(am, name);
		System.out.println("\n---EPILOGH EK---\n");
		//Routina Epiloghs Emvoliastikou kentrou
		for(int i=0;i<getVaccinationCenters().length;i++) {
			if(getVaccinationCenters()[i]!=null) {
				System.out.println(i+") KODIKOS: "+getVaccinationCenters()[i].getCode()+" TITLOS:"+getVaccinationCenters()[i].getCode()+" POLH:"+getVaccinationCenters()[i].getCity());
			}
		}
		System.out.printf("EISAGETE EPILOGH: ");
		int ch = sc.nextInt();
		//Eisgvgh iatrou sto epilegmeno EK
		getVaccinationCenters()[ch].addDoctor(tempDoc);
	}
	
	public void addRandevu() {
		Scanner sc = new Scanner(System.in);
		//Paragogh tyxaiv arithmwn apo 0 -200
		int randevuCode = new Random().nextInt(200);
		//Arxikopoihsh metablhtwn
		InsuredPerson selectedInsuredPerson = null;
		VaccinationCenter selecteVaccinationCenter =null;
		Doctor selectedDoctor = null;
		int selectedDay =0;
		
		
		System.out.println("\n---NEO RANTEBOY---\n");
		//Routina Epiloghs Asfalismenou
//		for(int i=0;i<getInsuredPersons().length;i++) {
//			if(getInsuredPersons()[i]!=null) {
//				System.out.println(i+") AMKA:"+getInsuredPersons()[i].getAmka()+" ONOMA:"+getInsuredPersons()[i].getName()+" POLH:"+getInsuredPersons()[i].getCity());				
//			}
//		}
		System.out.printf("Dose AMKA Asfalismenou: ");
		long insSelected =sc.nextLong();
		for(int i=0;i<getInsuredPersons().length;i++) {
			if(getInsuredPersons()[i]!=null && getInsuredPersons()[i].getAmka()==insSelected) {
				selectedInsuredPerson=	getInsuredPersons()[i];	
			}
		}
		if(selectedInsuredPerson==null) {
			System.out.println("DEN BRETHIKE ASFALISMENOS ME TO AMKA "+insSelected);
			return;
		}
		
		
		//Routina Epiloghs Vaccination Center
		for(int i=0;i<getVaccinationCenters().length;i++) {
			if(getVaccinationCenters()[i]!=null && selectedInsuredPerson.getCity().equals(getVaccinationCenters()[i].getCity())) {
				selecteVaccinationCenter = getVaccinationCenters()[i];
			}
		}
		if(selecteVaccinationCenter==null) {
			System.out.println("DEN VRETHIKE EK STHN POLH TOY ASFALISMENOU");
			return;
		}else {
			System.out.println("EPILEXTIKE EK:"+selecteVaccinationCenter.getCode() +" TITLE:"+selecteVaccinationCenter.getTitle());
		}
		
		
		//Routina epiloghs hmeras
		for(int i=0;i<selecteVaccinationCenter.getDays().length;i++) {
			System.out.println(i+") "+(1900+selecteVaccinationCenter.getDays()[i].getDate().getYear())+"-"+(selecteVaccinationCenter.getDays()[i].getDate().getMonth()+1)+"-"+selecteVaccinationCenter.getDays()[i].getDate().getDate());
		}
		System.out.printf("EPILEKSE MERA: ");
		selectedDay = sc.nextInt();
		
		
		//Routina epiloghs TimeSlot
		TimeSlot[] tsArray =selecteVaccinationCenter.getDays()[selectedDay].getTimeSlots();
		//Helping string
		String availability="";
		for(int i=0;i<tsArray.length;i++) {	
			//Psaxnei mexri to plithos tvn iatrvn poy exei to ek
			for(int j=0;j<selecteVaccinationCenter.getDoctorsCounter();j++) {
				//Ean vrei keno tote gemize to boithitiko string me th leksi Available. Alliws grafei Full.
				if(tsArray[i].getRandevus()[j]==null) {
					availability = "->Available";			
				}else {
					availability = "-->***FULL***";
				}
			}
			System.out.println(i+") "+tsArray[i].getDate()+availability);
		}
		System.out.printf("EPILEKSE WRA: ");
		int timeSlotSelected =sc.nextInt();
		//Routina anathesis rantebou sthn prwth kenh uesh tou pinaka randevu tou timeslot.
		int doctorPosition =-1;
		for(int i=0;i<selecteVaccinationCenter.getDoctorsCounter();i++) {
			if(tsArray[timeSlotSelected].getRandevus()[i]==null) {
				doctorPosition =i;
			}
		}
		//Elegxos ean o xeiristiw epelekse thesh pou einai FULL
		if(doctorPosition==-1) {
			System.out.println("DEN YPARXEI DIATHESIMOTHTA STO EPILEGMENO XRONIKO PERITHORIO");
			System.out.println("PROSPATHISTE PALI...");
			return;
		}
		
		
		//Selection of Doctor
		int minValue = Integer.MAX_VALUE;
		for(int i=0;i<selecteVaccinationCenter.getDoctors().length;i++) {
			if(selecteVaccinationCenter.getDoctors()[i]!=null && selecteVaccinationCenter.getDoctors()[i].getRandevusCounter()<=minValue) {
				minValue = selecteVaccinationCenter.getDoctors()[i].getRandevusCounter();
				selectedDoctor=selecteVaccinationCenter.getDoctors()[i];
			}
		}
		
		//Instantiation Randevu
		Randevu createdRandevu =new Randevu(randevuCode,selectedInsuredPerson,selecteVaccinationCenter,selectedDoctor);
		createdRandevu.setDate(tsArray[timeSlotSelected].getDate());
		//Anathesh Randevu sto EK
		selecteVaccinationCenter.addRantevu(createdRandevu, selectedDay, timeSlotSelected, doctorPosition);
		////Anathesh Randevu ston iatro
		selectedDoctor.addRandevu(createdRandevu);
		//Anathesh Randevu ston Asfalismeno
		selectedInsuredPerson.addRandevu(createdRandevu);
			
		
	}
	
	public void menuFindAndPrintRandevu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n---EYRESH KI EKTYPVSH RANTEBOY---\n");
		System.out.println("------------");
		System.out.println("1) Anazhthsh me AMKA");
		System.out.println("2) Anazhthsh me EK");
		System.out.println("3) Anazhthsh me AM Iatrou");
		System.out.println("4) Epistofh sto Kyrio menu");
		System.out.println("------------");
		int choise=sc.nextInt();
		
		switch(choise) {
		case 1:
			//Anazhthsh me AMKA
			System.out.printf("--Dose AMKA: ");
			long amkaSelected = sc.nextLong();
			for(int i=0;i<insuredPersons.length;i++) {
				if(insuredPersons[i]!=null && insuredPersons[i].getAmka()==amkaSelected) {
					Randevu r =insuredPersons[i].getRandevu();
					System.out.println("RANDEVU: "+r.getCode()+" EK:"+r.getVc().getCode()+" IATROS:"+r.getDoctor().getName()+" HMNIA:"+r.getDate());
				}
				
			}
			break;
		case 2:
			//Anazhthsh me EK
			System.out.printf("--Dose EK code: ");
			int codeSelected= sc.nextInt();
			VaccinationCenter vc = null;
			for(int i=0;i<vaccinationCenters.length;i++) {
				if(vaccinationCenters[i]!=null && vaccinationCenters[i].getCode()==codeSelected) {
					vc=vaccinationCenters[i];
				}
			}
			if(vc==null) {
				System.out.println("DEN BRETHIKE EK!!!");
				return;
			}
			//routina anazhthshs se 3D pinaka
			Randevu[][][] randevus = vc.getRandevus();
			for(int i=0;i<vc.getDays().length;i++) {
				for(int j=0;j<vc.getDays()[i].getTimeSlots().length;j++) {
					for(int k=0;k<vc.getDays()[i].getTimeSlots()[j].getRandevus().length;k++) {
						if(vc.getDays()[i].getTimeSlots()[j].getRandevus()[k]!=null) {
							Randevu r =vc.getDays()[i].getTimeSlots()[j].getRandevus()[k];
							System.out.println("RANDEVU: "+r.getCode()+" EK:"+r.getVc().getCode()+" IATROS:"+r.getDoctor().getName()+" HMNIA:"+r.getDate());
						}
					}
				}
			}
			
			
			break;
		case 3:
			System.out.printf("--Dose AM doctor: ");
			String doctorSelected=sc.next();
			for(int i=0;i<vaccinationCenters.length;i++) {
				if(vaccinationCenters[i]!=null) {
					Doctor[] doctors = vaccinationCenters[i].getDoctors();
					for(int j=0;j<doctors.length;j++) {
						if(doctors[j]!=null && doctors[j].getaMhtrwou().equals(doctorSelected)) {
							Randevu[] rands = doctors[j].getRandevus();
							for(int k=0;k<rands.length;k++) {
								if(rands[k]!=null) {
									Randevu r = rands[k];
									System.out.println("RANDEVU: "+r.getCode()+" EK:"+r.getVc().getCode()+" IATROS:"+r.getDoctor().getName()+" HMNIA:"+r.getDate());
								}
							}
						}
					}
				}
			}

			break;
		case 4:
			break;
		}
		
		
	}
	
	
	public void menuPrintInsuredPersons() {
		System.out.println("\n---EKTYPWSH ASFALISMENVN---\n");
		for(int i=0;i<getInsuredPersons().length;i++) {
			if(getInsuredPersons()[i]!=null) {
				System.out.println(i+") AMKA:"+getInsuredPersons()[i].getAmka()+" ONOMA:"+getInsuredPersons()[i].getName()+" POLH:"+getInsuredPersons()[i].getCity());
				if(getInsuredPersons()[i].getRandevu()!=null) {
					Randevu r = getInsuredPersons()[i].getRandevu();
					System.out.println("\tRANDEVU: "+r.getCode()+" EK:"+r.getVc().getCode()+" IATROS:"+r.getDoctor().getName()+" HMNIA:"+r.getDate());
				}					
			}
		}
	}
	
	public void menuPrintVaccinationCenters() {
		System.out.println("\n---EKTYPWSH EMBOLIASTIKWN KENTRWN---\n");
		for(int i=0;i<getVaccinationCenters().length;i++) {
			if(getVaccinationCenters()[i]!=null) {
				System.out.println(i+") KODIKOS: "+getVaccinationCenters()[i].getCode()+" TITLOS:"+getVaccinationCenters()[i].getCode()+" POLH:"+getVaccinationCenters()[i].getCity());
			}
		}
	}
	
	public void menuPrintDoctors() {
		System.out.println("\n---EKTYPWSH IATRWN---\n");
		for(int i=0;i<getVaccinationCenters().length;i++) {
			if(getVaccinationCenters()[i]!=null) {
				for(int j=0;j<getVaccinationCenters()[i].getDoctors().length;j++) {
					if(getVaccinationCenters()[i].getDoctors()[j]!=null) {
						System.out.println("\tIATROS: AM:"+getVaccinationCenters()[i].getDoctors()[j].getaMhtrwou()+" ONOMA:"+getVaccinationCenters()[i].getDoctors()[j].getName());
					}
				}
			}
			
		}
	}
	
	
	//Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Day[] getDays() {
		return days;
	}

	public void setDays(Day[] days) {
		this.days = days;
	}

	public InsuredPerson[] getInsuredPersons() {
		return insuredPersons;
	}

	public void setInsuredPersons(InsuredPerson[] insuredPersons) {
		this.insuredPersons = insuredPersons;
	}

	public VaccinationCenter[] getVaccinationCenters() {
		return vaccinationCenters;
	}

	public void setVaccinationCenters(VaccinationCenter[] vaccinationCenters) {
		this.vaccinationCenters = vaccinationCenters;
	}


	

	
	
	
	
	

}
