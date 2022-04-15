package ru.netology;

import lombok.Data;

@Data
public class Repository {
    private FilmData[] movies = new FilmData[0];

    public void save(FilmData newFilm) {
        FilmData[] tmp = new FilmData[movies.length + 1];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = (movies[i]);
        }
        tmp[tmp.length - 1] = newFilm;
        this.movies = tmp;
    }

    public FilmData[] findAll() {
        return movies;
    }

    public FilmData findById(int id) {
        FilmData resultMovie = null;
        for (FilmData movie : movies) {
            if (movie.getId() == id) {
                resultMovie = movie;
            }
        }
        return resultMovie;
    }

    public void removeById(int id) {
        FilmData[] tmp = new FilmData[movies.length - 1];
        int index = 0;
        for (int i = 0; i < movies.length; i++) {
            if (movies[i].getId() != id) {
                tmp[i] = (movies[i]);
                tmp[index] = movies[i];
                index++;
            }
        }
        movies = tmp;
    }
    public void removeAll(){
        movies = null;
    }
    public int getMoviesNumber(){
        return movies.length;
    }
}
