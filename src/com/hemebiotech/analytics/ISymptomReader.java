package com.hemebiotech.analytics;

import java.util.List;

/**
 * The {@code ISymptomReader} interface defines a contract for reading symptom data
 * from any type of source (a text file or database).
 *
 * @author Raphaël Bazelaire
 * @version 1.0
 * @since 2025-10-27
 *
 */
public interface ISymptomReader {

    /**
     * Reads a list of symptoms from a source.
     *
     * @return a {@link List} of symptoms.
     */
	List<String> getSymptoms();
}
