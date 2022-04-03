import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Comparator;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ListUtilsTest {

    private MyList<String> list;

    @BeforeEach
    private void init() {
        list = new MyArrayList<>();
    }

    @Test
    public void shouldSortStringsWithNatureOrder() {
        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            list.add(String.valueOf(random.nextInt(10)));
        }

        list=ListUtils.qSort(list);

        for (int i = 0; i <list.size()-1 ; i++) {
            assertTrue(list.get(i).compareTo(list.get(i + 1)) <= 0);
        }
    }

    @Test
    public void shouldSortStringsWithLength() {
        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            list.add(String.valueOf(random.nextInt(10000)));
        }
        Comparator<String> c = (o1, o2) -> {
            if (o1.length() > o2.length()) {
                return 1;
            } else if (o1.length() < o2.length()) {
                return -1;
            } else {
                return 0;
            }
        };

        list=ListUtils.qSort(list, c);

        for (int i = 0; i <list.size()-1 ; i++) {
            assertTrue(list.get(i).length()<=list.get(i+1).length());
        }
    }
}
