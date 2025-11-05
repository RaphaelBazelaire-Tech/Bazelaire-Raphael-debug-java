package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {

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
