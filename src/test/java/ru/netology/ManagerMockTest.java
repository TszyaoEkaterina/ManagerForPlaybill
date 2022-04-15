package ru.netology;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ManagerMockTest {
    @Mock
    private Repository repo;
    @InjectMocks
    private Manager manager;
    private FilmData first = new FilmData(1,"first","111");
    private FilmData second = new FilmData(2,"second","222");
    private FilmData third = new FilmData(3,"third","333");
    @Test
    public void shouldFindAll(){
        FilmData[] returned = new FilmData[]{first,second,third};
        doReturn(returned).when(repo).findAll();
        FilmData[] expected = {first,second,third};
        FilmData[] actual = manager.findAll();
        assertArrayEquals(expected,actual);

        verify(repo).findAll();
    }

}
