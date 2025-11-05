package com.hemebiotech.analytics;

import java.util.*;

public class AnalyticsCounter {

    private final ISymptomReader reader;
    private final ISymptomWriter writer;

    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public List<String> getSymptoms() {
        return reader.getSymptoms();
    }

    public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
        if (symptoms == null) return Collections.emptyMap();

        return new TreeMap<>(symptoms);
    }

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

    public void writeSymptoms(Map<String, Integer> symptoms) {
        writer.writeSymptoms(symptoms);
    }
}
