package ru.netology;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class FilmData {
    private int id;
    private String filmName;
    private String genre;
}
