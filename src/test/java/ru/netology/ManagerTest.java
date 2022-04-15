package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ManagerTest {
    Manager manager = new Manager();
    Repository repo = new Repository();
    FilmData first = new FilmData(1,"first","111");
    FilmData second = new FilmData(2,"second","222");
    FilmData third = new FilmData(3,"third","333");
    FilmData forth = new FilmData(4,"forth","444");
    FilmData fifth = new FilmData(5,"fifth","555");
    FilmData sixth = new FilmData(6,"sixth","666");
    FilmData seventh = new FilmData(7,"seventh","777");
    FilmData eighth = new FilmData(8,"eighth","888");
    FilmData ninth = new FilmData(9,"ninth","999");
    FilmData tenth = new FilmData(10,"tenth","10");
    FilmData eleventh = new FilmData(11,"eleventh","11");

    @Test
    void shouldAddIfNotContainsMovies() {
        manager.addFilm(first);
        FilmData[] actual = manager.findAll();
        FilmData[] expected = {first};
        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldAddIfContains1Movie() {
        FilmData[] movies = {first};
        manager.setMovies(movies);

        manager.addFilm(second);
        FilmData[] actual = manager.findAll();
        FilmData[] expected = {first, second};
        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldAddIfContainsMoreMovies() {
        FilmData[] movies = {first, second, third};
        manager.setMovies(movies);

        manager.addFilm(forth);
        FilmData[] actual = manager.findAll();
        FilmData[] expected = {first, second, third, forth};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAllIfContainsMovies() {
        FilmData[] movies = {first, second, third};
        manager.setMovies(movies);
        FilmData[] actual = manager.findAll();
        FilmData[] expected = {first, second, third};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindLastWithUnchangedLimitIfContainsMoviesLessThanLimit() {
        FilmData[] movies = {first, second, third};
        manager.setMovies(movies);

        FilmData[] actual = manager.findLast();
        FilmData[] expected = {third,second,first};
        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldFindLastWithUnchangedLimitIfContainsMoviesMoreThanLimit() {
        FilmData[] movies = {first, second, third, forth,fifth,sixth,seventh,eighth,ninth,tenth,eleventh};
        manager.setMovies(movies);

        FilmData[] actual = manager.findLast();
        FilmData[] expected = {eleventh,tenth,ninth,eighth,seventh, sixth,fifth,forth,third,second};
        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldFindLastWithChangedLimitIfContainsMoviesLessThanLimit() {
        FilmData[] movies = {first, second, third, forth};
        manager.setMovies(movies);
        manager.setMaxForLastFilms(5);
        FilmData[] actual = manager.findLast();
        FilmData[] expected = {forth,third,second,first};
        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldFindLastWithChangedLimitIfContainsMoviesMoreThanLimit() {
        FilmData[] movies = {first, second, third, forth,fifth,sixth,seventh,eighth};
        manager.setMovies(movies);
        manager.setMaxForLastFilms(5);
        FilmData[] actual = manager.findLast();
        FilmData[] expected = {eighth,seventh, sixth,fifth,forth};
        assertArrayEquals(expected, actual);
    }
}



