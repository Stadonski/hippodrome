import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class HippodromeTest {

    @Test
    public void nullHorsesException(){
        IllegalArgumentException e =  assertThrows(IllegalArgumentException.class, () -> new Hippodrome(null));
        assertEquals("Horses cannot be null.", e.getMessage());
    }

    @Test
    public void emptyHorsesException(){
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Hippodrome(new ArrayList<>()));
        assertEquals("Horses cannot be empty.", e.getMessage());
    }

    @Test
    public void getHorses(){
        List<Horse> horses = new ArrayList<>();
        for (int i = 1; i < 30; i++) {
            horses.add(new Horse("" + i, i, i));
        }
        Hippodrome hippodrome = new Hippodrome(horses);
        assertEquals(horses, hippodrome.getHorses());
    }
    @Test
    public void move(){
        List<Horse> horses = new ArrayList<>();
        for (int i = 1; i < 30; i++) {
            horses.add(mock(Horse.class));
        }
        new Hippodrome(horses).move();
        for(Horse horse : horses){
            verify(horse).move();
        }

    }

    @Test
    public void getWinner() {
        Horse horse1 = new Horse("Plotva 1", 1, 1);
        Horse horse2 = new Horse("Plotva 2", 2, 2);
        Horse horse3 = new Horse("Plotva 3", 3, 3);
        Horse horse4 = new Horse("Plotva 4", 4, 4);

        Hippodrome hippodrome = new Hippodrome(List.of(horse1, horse2, horse3, horse4));

        assertSame(horse4, hippodrome.getWinner());
    }

}