package ru.netology;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Manager {
    private String[] movies = new String[0];
    private int maxForLastFilms = 10;

    public void addFilm(String newFilm) {
        String[] tmp = new String[movies.length + 1];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = (movies[i]);
        }
        tmp[tmp.length - 1] = newFilm;
        movies = tmp;
    }

    public String[] findAll() {
        return movies;
    }

    public String[] findLast() {
        int resultLength;
        if (maxForLastFilms < movies.length) {
            resultLength = maxForLastFilms;
        } else {
            resultLength = movies.length;
        }
        String[] lastMovies = new String[resultLength];
        for (int i = 0; i < resultLength; i++) {
            int index = movies.length - 1 - i;
            lastMovies[i] = movies [index];
        }
        return lastMovies;
    }
}
