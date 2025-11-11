package com.hemebiotech.analytics;

import java.util.*;

/**
 * The {@code AnalyticsCounter} class is the class to performing analysis operations
 * on a list of symptoms read from an input source (like a text file and database) and writing the results to destination file.
 *
 * <p>It provides methods like :</p>
 * <ul>
 *     <li>Read a list of symptoms from a file (thanks to {@link ISymptomReader})</li>
 *     <li>Count each symptom in the file</li>
 *     <li>Sort the counted symptoms alphabetically</li>
 *     <li>Write results to an output file (thanks to {@link ISymptomWriter})</li>
 * </ul>
 *
 * @author Raphaël Bazelaire
 * @version 1.0
 * @since 2025-10-17
 *
 */
public class AnalyticsCounter {

    private final ISymptomReader reader;
    private final ISymptomWriter writer;

    /**
     * Constructs an {@code AnalyticsCounter} with the reader and writer.
     *
     * @param reader the reader used to retrieve symptoms data.
     * @param writer the writer used to store the processed results.
     * Both cannot be {@code null}.
     */
    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    /**
     * Return the list of symptoms from the reader.
     *
     * @return a {@link List} of symptom names, or an empty list if no data found.
     */
    public List<String> getSymptoms() {
        return reader.getSymptoms();
    }

    /**
     * Sorts symptom map alphabetically by symptom name.
     *
     * @param symptoms a {@link Map} of symptoms and their counts.
     * @return a new {@link TreeMap} containing the same data sorted by keys or an empty map if no data found.
     */
    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
        if (symptoms == null) return Collections.emptyMap();

        return new TreeMap<>(symptoms);
    }

    /**
     * Count number of each symptom in the file.
     *
     * @param symptoms list of symptoms to count
     * @return a {@link Map} where each key is a symptom name with each value.
     */
    public Map<String, Integer> countSymptoms(List<String> symptoms) {
        Map<String, Integer> symptomCount = new HashMap<>();

        if (symptoms == null) return symptomCount;

        for (String symptom : symptoms) {
            if (symptom != null && !symptom.isEmpty()) {
                String cleanWrite = symptom.trim().toLowerCase();
                symptomCount.put(cleanWrite, symptomCount.getOrDefault(cleanWrite, 0) + 1);
            }
        }

        return symptomCount;
    }

    /**
     * Writes symptoms and their counts to the destination file.
     *
     * @param symptoms a {@link Map} containing the symptoms and their counts.
     */
    public void writeSymptoms(Map<String, Integer> symptoms) {
        writer.writeSymptoms(symptoms);
    }
}
