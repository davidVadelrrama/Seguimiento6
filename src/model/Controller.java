package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Controller implements Serializable {

	private ArrayList<Cartel> libroFences;
	private ArrayList<Cartel> peligrosos;

	public Controller() {
		libroFences = new ArrayList<Cartel>();
		peligrosos = new ArrayList<Cartel>();
	}

	public void loadFile1() {

		try {
			FileInputStream fis = new FileInputStream("Datos1.csv");
			BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
			String csv = "";
			String line;
			while ((line = reader.readLine()) != null) {
				csv += line+"\n";
			}
			String[] lines = csv.split("\n");
			for (int i = 1; i<lines.length; i++) {
				String[] params = lines[i].split("\\|");
				Cartel cartel = new Cartel(Integer.parseInt(params[0]),Integer.parseInt(params[1]),Boolean.parseBoolean(params[2]),params[3]);
				libroFences.add(cartel);
			}
			

			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println();

	}

	public void loadFile2() {
		try {
			FileInputStream fis = new FileInputStream("Datos2.csv");
			BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
			String csv = "";
			String line;
			while((line = reader.readLine()) != null) {
				csv += line;
			}
			String[] lines = csv.split("ln");
			for (int i = 1; i<lines.length; i++) {
				String[] params = lines[i].split("\\|");
				Cartel cartel = new Cartel(Integer.parseInt(params[0]),Integer.parseInt(params[1]),Boolean.parseBoolean(params[2]),params[3]);
				libroFences.add(cartel);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addElement(Cartel c) {
		libroFences.add(c);
	}

	public void saveFile() {
		try {
			File file = new File("data.txt");
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(this);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showFences() {
		for (Cartel c : libroFences) {
			System.out.println(c.toString()+"\n");
		}
		System.out.println("Total Bilboards: "+libroFences.size());
	}
	
	public void showDangerous() {
		for (Cartel cartel : libroFences) {
			int i = 0;
			if(cartel.getAlto()*cartel.getAncho() >= 200000 && !cartel.equals(peligrosos.get(i))) {
				peligrosos.add(cartel);
				i++;
			}
		}
	}
	
	public void savePeligrosos() {
		try {
			File file = new File("peligrosos.txt");
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(this);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
