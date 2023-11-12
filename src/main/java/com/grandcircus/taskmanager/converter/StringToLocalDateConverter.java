package com.grandcircus.taskmanager.converter;

import org.springframework.core.convert.converter.Converter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StringToLocalDateConverter implements Converter<String, LocalDate> {

    @Override
    public LocalDate convert(String source) {
        // Implement your own logic to convert the String to LocalDate
        // For example, assuming the date format is "yyyy-MM-dd"
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return LocalDate.parse(source, formatter);
        } catch (Exception e) {
            // Handle the exception or return a default value if the conversion fails
            return null; // You might want to handle this more gracefully in a real application
        }
    }
}
