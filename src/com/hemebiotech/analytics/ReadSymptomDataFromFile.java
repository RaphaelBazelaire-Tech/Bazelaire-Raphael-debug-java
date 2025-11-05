package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadSymptomDataFromFile implements ISymptomReader {

	private final String filepath;
	
	public ReadSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}
	
	@Override
	public List<String> getSymptoms() {
		ArrayList<String> result = new ArrayList<>();

        if (filepath == null) return result;

        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                result.add(line);
            }

        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier : " + filepath);
            e.printStackTrace();
		}
		
		return result;
	}

}
