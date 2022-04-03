import java.util.Comparator;
import java.util.Random;

/**
 * The class includes of two static methods fos sort {@link MyList} collection
 * quick sort is used as a sorting method
 *
 * @version 1.0
 * @see MyList
 * @see MyArrayList
 */
public class ListUtils {
    /**
     * This field used for select random pivot element
     */
    private static final Random random = new Random();

    /**
     * This method used for sort {@link MyList} elements in nature order
     * sorting occurs from the smaller element in ascending order
     *
     * @see MyList
     * @see MyArrayList
     * @see Comparable
     */
    public static <T extends Comparable<T>> MyList<T> qSort(MyList<T> list) {
        if (list.size() < 2) {
            return list;
        }

        int pivotIndex = getPivot(list.size());
        T pivot = list.get(pivotIndex);
        list.remove(pivotIndex);

        MyList<T> left = new MyArrayList<>();
        MyList<T> right = new MyArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).compareTo(pivot) <= 0) {
                left.add(list.get(i));
            } else if (list.get(i).compareTo(pivot) > 0) {
                right.add(list.get(i));
            }
        }
        return concat(qSort(left), pivot, qSort(right));
    }

    /**
     * This method used for sort {@link MyList} elements if they implements {@link Comparator}
     * sorting occurs from the smaller element in ascending order
     *
     * @see MyList
     * @see MyArrayList
     * @see Comparator
     */
    public static <T> MyList<T> qSort(MyList<T> list, Comparator<T> c) {
        if (list.size() < 2) {
            return list;
        }

        int pivotIndex = getPivot(list.size());
        T pivot = list.get(pivotIndex);
        list.remove(pivotIndex);

        MyList<T> left = new MyArrayList<>();
        MyList<T> right = new MyArrayList<>();

        for (int i = 0; i < list.size(); i++) {

            if (c.compare(list.get(i), pivot) <= 0) {
                left.add(list.get(i));
            } else if (c.compare(list.get(i), pivot) > 0) {
                right.add(list.get(i));
            }
        }
        return concat(qSort(left, c), pivot, qSort(right, c));
    }

    /**
     * This method used for choice random index of list
     *
     * @param size - upper bound for a random element
     * @see Random
     */
    private static int getPivot(int size) {
        return random.nextInt(size);
    }

    /**
     * This method used for concatenate three elements in one {@link MyList}
     *
     * @param left  - {@link MyList} elements that are bellow of pivot
     * @param pivot - middle element
     * @param right - {@link MyList} elements that are higher of pivot
     * @see MyList
     */
    private static <T> MyList<T> concat(MyList<T> left, T pivot, MyList<T> right) {
        MyList<T> result = new MyArrayList<>(left.size() + right.size() + 1);
        for (int i = 0; i < left.size(); i++) {
            result.add(left.get(i));
        }
        result.add(pivot);
        for (int i = 0; i < right.size(); i++) {
            result.add(right.get(i));
        }
        return result;
    }
}
