package main;

import java.util.Random;
import java.util.Scanner;

import model.Doctor;
import model.InsuredPerson;
import model.Randevu;
import model.VaccinationCenter;
import model.VaccinationSystem;
import utils.Day;

public class Main {

	public static void main(String[] args) {
		System.out.println("Vaccination System Starting");
		VaccinationSystem vs = new VaccinationSystem("ETHNIKO PROGRAMMA EMBOLIASMWN", "https://emvolio.gov.gr");
		//manual eisagvgh asfalismenwn
		InsuredPerson p1 = new InsuredPerson(1111111111L, "Asfalismenos 1", "CHANIA");
		InsuredPerson p2 = new InsuredPerson(2222222222L, "Asfalismenos 2", "CHANIA");
		InsuredPerson p3 = new InsuredPerson(3333333333L, "Asfalismenos 3", "CHANIA");
		InsuredPerson p4 = new InsuredPerson(4444444444L, "Asfalismenos 4", "CHANIA");
		InsuredPerson p5 = new InsuredPerson(5555555555L, "Asfalismenos 5", "CHANIA");
		InsuredPerson p6 = new InsuredPerson(6666666666L, "Asfalismenos 6", "RETHYMNO");
		InsuredPerson p7 = new InsuredPerson(7777777777L, "Asfalismenos 7", "RETHYMNO");
		InsuredPerson p8 = new InsuredPerson(8888888888L, "Asfalismenos 8", "RETHYMNO");
		InsuredPerson p9 = new InsuredPerson(9999999999L, "Asfalismenos 9", "RETHYMNO");
		vs.addInsurancedPerson(p1);
		vs.addInsurancedPerson(p2);
		vs.addInsurancedPerson(p3);
		vs.addInsurancedPerson(p4);
		vs.addInsurancedPerson(p5);
		vs.addInsurancedPerson(p6);
		vs.addInsurancedPerson(p7);
		vs.addInsurancedPerson(p8);
		vs.addInsurancedPerson(p9);
		
		Day[] manualDays = new Day[7];
		manualDays[0]= new Day(22);
		manualDays[1]= new Day(23);
		manualDays[2]= new Day(24);
		manualDays[3]= new Day(25);
		manualDays[4]= new Day(26);
		manualDays[5]= new Day(27);
		manualDays[6]= new Day(28);
	
		//manual eisagwgh Vaccination Center
		VaccinationCenter vc1 =new VaccinationCenter(22222, "CH-22", "CHANIA");
		vc1.setDays(manualDays);
		Doctor d1 = new Doctor("111111","Doctor 1");
		Doctor d2 = new Doctor("222222","Doctor 2");
		Doctor d3 = new Doctor("333333","Doctor 3");
		vc1.addDoctor(d1);
		vc1.addDoctor(d2);
		vc1.addDoctor(d3);
		
		Day[] manualDays2 = new Day[7];
		manualDays2[0]= new Day(22);
		manualDays2[1]= new Day(23);
		manualDays2[2]= new Day(24);
		manualDays2[3]= new Day(25);
		manualDays2[4]= new Day(26);
		manualDays2[5]= new Day(27);
		manualDays2[6]= new Day(28);
		VaccinationCenter vc2 =new VaccinationCenter(33333, "RTH-33", "RETHYMNO");
		vc2.setDays(manualDays2);
		Doctor d4 = new Doctor("444444","Doctor 4");
		Doctor d5 = new Doctor("555555","Doctor 5");
		vc2.addDoctor(d4);
		vc2.addDoctor(d5);
		
		Randevu r1 =new Randevu(20,p1,vc1,d1);
		r1.setDate(manualDays[0].getTimeSlots()[0].getDate());
		d1.addRandevu(r1);
		p1.addRandevu(r1);
		Randevu r2 =new Randevu(21,p2,vc1,d1);
		r2.setDate(manualDays[0].getTimeSlots()[3].getDate());
		d1.addRandevu(r2);
		p2.addRandevu(r2);
		Randevu r3 =new Randevu(22,p3,vc1,d2);
		r3.setDate(manualDays[0].getTimeSlots()[3].getDate());
		d2.addRandevu(r3);
		p3.addRandevu(r3);
		Randevu r4 =new Randevu(23,p4,vc1,d3);
		r4.setDate(manualDays[0].getTimeSlots()[3].getDate());
		d3.addRandevu(r4);
		p4.addRandevu(r4);
		Randevu r5 =new Randevu(24,p5,vc1,d1);
		r5.setDate(manualDays[1].getTimeSlots()[1].getDate());
		d1.addRandevu(r5);
		p5.addRandevu(r5);
		
		vc1.addRantevu(r1, 0, 0, 0);
		vc1.addRantevu(r2, 0, 3, 0);
		vc1.addRantevu(r3, 0, 3, 1);
		vc1.addRantevu(r4, 0, 3, 2);
		vc1.addRantevu(r5, 1, 1, 0);
		
		Randevu rr1 = new Randevu(30,p6,vc2,d4);
		rr1.setDate(manualDays[1].getTimeSlots()[0].getDate());
		d4.addRandevu(rr1);
		p6.addRandevu(rr1);
		Randevu rr2 = new Randevu(31,p7,vc2,d5);
		rr2.setDate(manualDays[1].getTimeSlots()[1].getDate());
		d5.addRandevu(rr2);
		p7.addRandevu(rr2);
		Randevu rr3 = new Randevu(32,p8,vc2,d5);
		rr3.setDate(manualDays[1].getTimeSlots()[2].getDate());
		d5.addRandevu(rr3);
		p8.addRandevu(rr3);
		Randevu rr4 = new Randevu(33,p9,vc2,d4);
		rr4.setDate(manualDays[2].getTimeSlots()[1].getDate());
		d4.addRandevu(rr4);
		p9.addRandevu(rr4);
		
		vc2.addRantevu(rr1, 1, 0, 0);
		vc2.addRantevu(rr2, 1, 1, 1);
		vc2.addRantevu(rr3, 1, 2, 0);
		vc2.addRantevu(rr4, 2, 0, 0);
		
		//Add Vaccination Centers to Vaccination System
		vs.addVaccinationCenter(vc1);
		vs.addVaccinationCenter(vc2);
		
		
		//Menu Epilogwn
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("#####---Menu---#####");
			System.out.println("1) Prosthiki Asfalismenou");
			System.out.println("2) Prosthiki Emvoliastikou Kentrou");
			System.out.println("3) Prosthiki Iatrou");
			System.out.println("4) Neo Randevu");
			System.out.println("5) Eyresh ki ektypwsh randevu");
			System.out.println("6) Provolh Asfalismenvn");
			System.out.println("7) Provolh Emvoliastikon Kentron");
			System.out.println("8) Provolh Iatron");
			System.out.println("9) Exit");
			System.out.printf("EPILOGH:");
			int choise= sc.nextInt();			
			switch (choise){
			case 1:
				vs.addInsuredPerson();
				break;
			case 2:
				vs.addEK();
				break;
			case 3:
				vs.addDoctor();		
				break;
			case 4:
				vs.addRandevu();
				break;
			case 5:
				vs.menuFindAndPrintRandevu();
				break;
			case 6:
				vs.menuPrintInsuredPersons();
				break;
			case 7:
				vs.menuPrintVaccinationCenters();
				break;
			case 8:
				vs.menuPrintDoctors();		
				break;
			case 9:
				System.out.println("Exiting...");
				System.exit(0);
				break;
			default:
				break;
			}
		}
	}
}
