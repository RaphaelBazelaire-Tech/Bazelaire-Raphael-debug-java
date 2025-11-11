package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * The main class of symptom analytics program.
 * This class make the reading, processing, sorting and writing of symptoms file.
 *
 * <p><b>Steps from main method</b></p>
 * <ol>
 *     <li>Reads symptoms from a file using {@link ReadSymptomDataFromFile}</li>
 *     <li>Counts symptoms using {@link AnalyticsCounter#countSymptoms(List)}</li>
 *     <li>Sorts symptoms using {@link AnalyticsCounter#sortSymptoms(Map)}</li>
 *     <li>Writes results to a file using {@link WriteSymptomDataToFile}</li>
 * </ol>
 *
 * @author Raphaël Bazelaire
 * @version 1.0
 * @since 2025-10-17
 *
 */
public class Main {

    /**
     * The main method of the application.
     * <p>
     *     Using a file named {@code symptoms.txt} and make a file named {@code result.out}.
     * </p>
     *
     */
    public static void main(String[] args) {

        String inputFile = "symptoms.txt";
        String outputFile = "result.out";

        ISymptomReader reader = new ReadSymptomDataFromFile(inputFile);
        ISymptomWriter writer = new WriteSymptomDataToFile(outputFile);
        AnalyticsCounter analyticsCounter = new AnalyticsCounter(reader, writer);

        List<String> symptoms = analyticsCounter.getSymptoms();
        Map<String, Integer> countSymptoms = analyticsCounter.countSymptoms(symptoms);
        Map<String, Integer> sortSymptoms = analyticsCounter.sortSymptoms(countSymptoms);
        analyticsCounter.writeSymptoms(sortSymptoms);

        System.out.println("Traitement terminé. Résultats écrits dans : " + outputFile);

    }
}
