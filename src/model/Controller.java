package model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;

public class Controller implements Serializable {

	public static ArrayList<Cartel> libroFences = new ArrayList<Cartel>();
	public Controller() {
		
	}
	public static void loadFile() {
		
		try {
			FileInputStream fis = new FileInputStream("Datos1.csv");
			BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
			String csv = "";
			String line;
			while((line = reader.readLine()) != null) {
				csv += line;
			}
			csv.split("ln");
			csv.split("\\|");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
	
	}
	public static void addElement(Cartel c) {
		libroFences.add(c);
	}
}
