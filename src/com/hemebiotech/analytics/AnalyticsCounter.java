package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class AnalyticsCounter implements ISymptomReader, ISymptomWriter {

	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;

    private final ISymptomReader reader;
    private final ISymptomWriter writer;

    // Création du constructeur - Paramètres ISymptomReader & ISymptomWriter
    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }
	
	public static void main(String args[]) throws Exception {
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();

		int i = 0;
		int headCount = 0;
		while (line != null) {
			i++;
			System.out.println("symptom from file: " + line);

            // Utilisation d'un switch à la place
			if (line.equals("headache")) {
				headCount++;
				System.out.println("number of headaches: " + headCount);
			}
			else if (line.equals("rush")) {
				rashCount++;
			}
			else if (line.contains("pupils")) {
				pupilCount++;
			}

			line = reader.readLine();
		}
		reader.close();
		
		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}

    /*
     * Retourne la méthode présente dans le "WriteSymptomDataToFile"
     * Possibilité de mettre la méthode dans cette classe ? (Obligation ?)
     */
    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
        if (symptoms == null) {
            return Collections.emptyMap(); // Retourne une collection vide, car absence de symptômes
        }

        return new TreeMap<>(symptoms); // TreeMap > Tri dans l'ordre alphabétique pour les informations
    }

    // Count Symptoms
    public Map<String, Integer> countSymptoms(List<String> symptoms) {
        Map<String, Integer> symptomCount = new HashMap<>();

        if (symptoms == null) {
            return symptomCount; // Retourne une map vide, en absence de symptômes
        }

        // Pour chaque symptôme, on vérifie son existence et s'il est complet
        for (String symptom : symptoms) {
            if (symptom != null && !symptom.isEmpty()) {
                symptomCount.put(symptom, symptomCount.getOrDefault(symptom, 0) + 1);
            }
        }

        return symptomCount;
    }

    // Retourne la méthode présente dans le "ReadSymptomDataToFile"
    public List<String> getSymptoms() {
        return reader.getSymptoms();
    }

    // Retourne la méthode présente dans le "WriteSymptomDataToFile"
    public void writeSymptoms(Map<String, Integer> symptoms) {
        writer.writeSymptoms(symptoms);
    }
}
