package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;

public class Controller implements Serializable {

	private ArrayList<Cartel> libroFences; 
	public Controller() {
		libroFences = new ArrayList<Cartel>();
	}
	public void loadFile() {
		
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
			FileInputStream fis2 = new FileInputStream("Datos2.csv");
			BufferedReader reader2 = new BufferedReader(new InputStreamReader(fis));
			String csv2 = "";
			String line2;
			while((line2 = reader2.readLine()) != null) {
				csv2 += line2;
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
	public void addElement(Cartel c) {
		libroFences.add(c);
	}
	
	public void saveFile() {
		try {
			File file = new File("data.csv");
			FileOutputStream fos = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
