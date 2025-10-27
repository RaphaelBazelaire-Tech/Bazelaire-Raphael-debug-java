package com.hemebiotech.analytics.symptoms;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {

    private String filePath;

    public WriteSymptomDataToFile(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {

        // Vérification du fichier "result.out" et la présence des symptômes
        if (filePath != null && symptoms != null) {
            try {

                // Mise en place du fichier d'écriture et de l'écriture des résultats
                FileWriter fileWriter = new FileWriter(filePath);
                BufferedWriter writer = new BufferedWriter(fileWriter);

                /*
                * Une boucle dans la map pour vérifier chaque symptôme
                * Écriture de chaque symptôme dans le format (symptôme : quantité)
                */
                for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                    writer.write(entry.getKey() + " : " + entry.getValue());
                    writer.newLine(); // Retour à la ligne à chaque nouveau symptôme détecté
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
