package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;

public class Controller implements Serializable {

	public Controller() {
		
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
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
	
	}
}
