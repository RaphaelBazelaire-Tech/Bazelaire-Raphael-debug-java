package com.hemebiotech.analytics;

import java.util.Map;

/**
 * The {@code ISymptomWriter} interface defines a contract for writing processed symptom data
 * to an output destination such as a file or a database.
 *
 * @author Raphaël Bazelaire
 * @version 1.0
 * @since 2025-10-17
 *
 */
public interface ISymptomWriter {

    /**
     * Writes a map of symptoms and their respective counts to a chosen output destination.
     *
     * @param symptoms a {@link Map} where keys represent symptom name
     *                 and values represent their corresponding occurrence counts.
     *
     */
    void writeSymptoms(Map<String, Integer> symptoms);
}
