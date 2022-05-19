package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
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
				csv += line + "\n";
			}
			String[] lines = csv.split("\n");
			for (int i = 1; i < lines.length; i++) {
				String[] params = lines[i].split("\\|");
				Cartel cartel = new Cartel(Integer.parseInt(params[0]), Integer.parseInt(params[1]),
						Boolean.parseBoolean(params[2]), params[3]);
				libroFences.add(cartel);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void loadFile2() {
		try {
			FileInputStream fis = new FileInputStream("Datos2.csv");
			BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
			String csv = "";
			String line;
			while ((line = reader.readLine()) != null) {
				csv += line + "\n";
			}
			String[] lines = csv.split("\n");
			for (int i = 1; i < lines.length; i++) {
				String[] params = lines[i].split("\\|");
				Cartel cartel = new Cartel(Integer.parseInt(params[0]), Integer.parseInt(params[1]),
						Boolean.parseBoolean(params[2]), params[3]);
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

	public void saveFences() {
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
			System.out.println(c.toString() + "\n");
		}
		System.out.println("Total Bilboards: " + libroFences.size());
	}
	
	public void loadFences() {
		File file = new File("data.txt");
		FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Object object = ois.readObject();
			Controller control = (Controller)object;
			this.libroFences = control.libroFences;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void addDangerous() {
		for (Cartel cartel : libroFences) {
			if (cartel.getAlto() * cartel.getAncho() >= 200000) {
				peligrosos.add(cartel);
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

	public void showDangerous() {
		for (Cartel cartel : peligrosos) {
			System.out.println(cartel.toString() + "\n");
		}
		System.out.println("Total of dangerous bilboards: "+ peligrosos.size());
		
	}

}
