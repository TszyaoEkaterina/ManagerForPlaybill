package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ManagerTest {
    Manager manager = new Manager();

    @Test
    void shouldAddIfNotContainsMovies() {
        manager.addFilm("first");
        String[] actual = manager.getMovies();
        String[] expected = {"first"};
        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldAddIfContains1Movie() {
        String[] movies = {"first"};
        manager.setMovies(movies);

        manager.addFilm("second");
        String[] actual = manager.getMovies();
        String[] expected = {"first", "second"};
        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldAddIfContainsMoreMovies() {
        String[] movies = {"first", "second", "third"};
        manager.setMovies(movies);

        manager.addFilm("forth");
        String[] actual = manager.getMovies();
        String[] expected = {"first", "second", "third", "forth"};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAllIfContainsMovies() {
        String[] movies = {"first", "second", "third"};
        manager.setMovies(movies);
        String[] actual = manager.findAll();
        String[] expected = {"first", "second", "third"};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindLastWithUnchangedLimitIfContainsMoviesLessThanLimit() {
        String[] movies = {"1", "2", "3"};
        manager.setMovies(movies);

        String[] actual = manager.findLast();
        String[] expected = {"3", "2", "1"};
        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldFindLastWithUnchangedLimitIfContainsMoviesMoreThanLimit() {
        String[] movies = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"};
        manager.setMovies(movies);

        String[] actual = manager.findLast();
        String[] expected = {"11", "10", "9", "8", "7", "6", "5", "4", "3", "2"};
        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldFindLastWithChangedLimitIfContainsMoviesLessThanLimit() {
        String[] movies = {"1", "2", "3", "4"};
        manager.setMovies(movies);
        manager.setMaxForLastFilms(5);
        String[] actual = manager.findLast();
        String[] expected = {"4", "3", "2","1"};
        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldFindLastWithChangedLimitIfContainsMoviesMoreThanLimit() {
        String[] movies = {"1", "2", "3", "4","5", "6", "7", "8"};
        manager.setMovies(movies);
        manager.setMaxForLastFilms(5);
        String[] actual = manager.findLast();
        String[] expected = {"8", "7", "6", "5","4"};
        assertArrayEquals(expected, actual);
    }
}



