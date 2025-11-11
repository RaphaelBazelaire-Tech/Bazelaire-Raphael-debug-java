package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * The {@code WriteSymptomDataToFile} class implements the {@link ISymptomWriter} interface.
 * It's using to write symptoms to a text file.
 *
 * <p>
 *     Each symptom and its count are written on a new line in the following format :
 *     symptom : count
 *
 *     If the file already exists, content will be overwritten.
 * </p>
 *
 * @author Raphaël Bazelaire
 * @version 1.0
 * @since 2025-10-17
 *
 */
public class WriteSymptomDataToFile implements ISymptomWriter {

    private final String filePath;

    /**
     * Constructs a new {@code WriteSymptomDataToFile} writer for the specific filepath.
     *
     * @param filePath (Path to the file where results will be written)
     */
    public WriteSymptomDataToFile(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Writes the given symptoms and their occurrence counts to the output file.
     *
     * Each map entry is written as a separate line using the format "symptom : count".
     * Existing content is overwritten.
     *
     * @param symptoms a {@link Map} containing the symptoms as keys and their counts as values;
     *
     */
    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {
        if (filePath == null || symptoms == null) return;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {

            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                writer.write(entry.getKey() + " : " + entry.getValue());
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Erreur lors de l'écriture du fichier : " + filePath);
            e.printStackTrace();
        }
    }
}
