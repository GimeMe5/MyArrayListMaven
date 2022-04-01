import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class MyArrayListTest {

    private MyArrayList<Integer> list;

    @BeforeEach
    public void init() {
        list = new MyArrayList<>();
    }

    @Test
    public void shouldReturnCurrentElement() {
        list.add(1);
        list.add(2);

        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
    }

    @Test
    public void shouldAddElementInArray() {
        list.add(1);

        assertEquals(1, list.get(0));
    }

    @Test
    public void shouldRemoveElementInArrayAndMoveNextElementsToRight() {
        int expectedResult = 50;

        for (int i = 0; i <100 ; i++) {
            list.add(i);
        }
        for (int i = 0; i <50 ; i++) {
            list.remove(0);
        }

        for (int i = 0; i < 50; i++) {
            assertEquals(expectedResult, list.get(i));
            expectedResult ++;
        }
    }

    @Test
    public void shouldReturnTrueIfElementContainsInList() {
        list.add(1);

        assertTrue(list.contains(1));
    }

    @Test
    public void shouldReturnFalseIfElementNotContainsInList() {
        list.add(1);

        assertFalse(list.contains(2));
    }

    @Test
    public void shouldReturnExactNumberOfElements() {
        for (int i = 0; i <25 ; i++) {
            list.add(i);
        }

        assertEquals(25,list.size());
    }

    @Test
    public void shouldPointOnExpectElement() {
        Iterator<Integer> iterator = list.iterator();
        for (int i = 0; i <25 ; i++) {
            list.add(i);
        }

        for (int i = 0; i <25 ; i++) {
            assertEquals(list.get(i), iterator.next());
        }
    }


}
