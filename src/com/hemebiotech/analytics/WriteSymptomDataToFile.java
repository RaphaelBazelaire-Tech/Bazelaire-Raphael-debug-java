package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {

    private String filePath;
    private AnalyticsCounter analyticsCounter;

    public WriteSymptomDataToFile(String filePath, AnalyticsCounter analyticsCounter) {
        this.filePath = filePath;
        this.analyticsCounter = analyticsCounter;
    }

    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {

        // Vérification du fichier "result.out" et la présence des symptômes
        if (filePath != null && symptoms != null) {

            Map<String, Integer> sortedSymptoms = analyticsCounter.sortSymptoms(symptoms); // Tri des symptômes avant écriture

            try {

                // Mise en place du fichier d'écriture et de l'écriture des résultats
                FileWriter fileWriter = new FileWriter(filePath);
                BufferedWriter writer = new BufferedWriter(fileWriter);

                /*
                * Une boucle dans la map pour vérifier chaque symptôme
                * Écriture de chaque symptôme dans le format (symptôme : quantité)
                */
                for (Map.Entry<String, Integer> entry : sortedSymptoms.entrySet()) {
                    writer.write(entry.getKey() + " : " + entry.getValue());
                    writer.newLine(); // Retour à la ligne à chaque nouveau symptôme détecté
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
