package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The {@code ReadSymptomDataFromFile} class implements the {@link ISymptomReader} interface.
 * It's using to reading symptoms from a text file.
 *
 * <p>
 *     Each line of the text file represents a symptom.
 *     If an error or a missing file is detected, it can return an empty list.
 * </p>
 *
 * @author Raphaël Bazelaire
 * @version 1.0
 * @since 2025-10-17
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private final String filepath;

    /**
     * Constructs a new {@code ReadSymptomDataFromFile} reader for the specific filepath.
     *
     * @param filepath (Path to the file where the list of symptoms is contains)
     */
	public ReadSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}

    /**
     * @return a {@link List} of strings representing symptoms or a empty list if the file can't be read.
     */
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
