package ru.netology;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Manager {
    private int maxForLastFilms = 10;
    private Repository repo = new Repository();
    private FilmData[] movies = findAll();
    public void setMovies(FilmData[] movies) {
        this.movies = movies;
        repo.setMovies(movies);
    }
    public void setMaxForLastFilms(int maxForLastFilms) {
        this.maxForLastFilms = maxForLastFilms;
    }

    public void addFilm(FilmData newFilm) {
        repo.save(newFilm);
    }

    public FilmData[] findAll() {
        return repo.findAll();
    }

    public FilmData[] findLast() {
        int resultLength;
        //int moviesNumber = repo.getMoviesNumber();
        if (maxForLastFilms < movies.length) {
            resultLength = maxForLastFilms;
        } else {
            resultLength = movies.length;
        }
        FilmData[] lastMovies = new FilmData[resultLength];
        for (int i = 0; i < resultLength; i++) {
            int index = movies.length - 1 - i;
            lastMovies[i] = movies [index];
        }
        return lastMovies;
    }
}