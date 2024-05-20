package com.capstoneproject.boardgameevent.rest.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Data
public class SearchEventForm {

    String searchTitle;
    String startDate;
    String endDate;
    String gameId;

    LocalDateTime fromDate;
    LocalDateTime toDate;
    Integer gameKey;

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    public void transformData() {
        try {
            if (startDate != null && !startDate.isBlank()) {
                fromDate = LocalDateTime.parse(startDate, FORMATTER);
            }
            if (endDate != null && !endDate.isBlank()) {
                toDate = LocalDateTime.parse(endDate, FORMATTER);
            }
            if (gameId != null && !gameId.isBlank()) {
                gameKey = Integer.parseInt(gameId);
            }
        } catch (DateTimeParseException e) {
            // Обработка ошибки парсинга
            e.printStackTrace();
        } catch (NumberFormatException e) {
            // Обработка ошибки парсинга числа
            e.printStackTrace();
        }
    }
}
