package Main;

import java.util.Scanner;
import model.*;

public class Main {
	public static Scanner sc = new Scanner(System.in);
	static Controller control = new Controller();

	public static void main(String[] args) {

		control.loadFences();
		int option = -1;
		do {
			System.out.println("---------BRAND-BILBOARD-MENU-----------" + "\n 1) Import publicity bilboards from data bases"
					+ "\n 2) Add new publicity bilboard" + "\n 3) Show all publicity bilboards"
					+ "\n 4) Report of dangerous bilboards" + "\n 0) quit");
			option = sc.nextInt();
			switchMenu(option);
		} while (option != 0);
	}

	public static void switchMenu(int option) {
		switch (option) {
		case 1:
			control.loadFile1();
			control.loadFile2();
			control.saveFences();
			break;

		case 2:
			System.out.println("Input the width of the bilboard");
			int ancho = sc.nextInt();
			System.out.println("Input the height of the bilboard");
			int alto = sc.nextInt();
			System.out.println("1) if the bilboard is in use" + "\n2) if the bilboard is not in use");
			int temp = sc.nextInt();
			sc.nextLine();
			boolean inUse = false;
			if (temp == 1) {
				inUse = true;
			}
			System.out.println("bilboard´s brand");
			String marca = sc.nextLine();
			Cartel bilboard = new Cartel(ancho, alto, inUse, marca);
			control.addElement(bilboard);
			break;
		case 3:
			control.showFences();
			break;

		case 4:
			control.addDangerous();
			control.savePeligrosos();
			control.showDangerous();
			break;
		case 0:
			System.out.println("good bye bitch");
			break;
		}

	}

}
