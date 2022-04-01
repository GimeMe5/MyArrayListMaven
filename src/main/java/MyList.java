import java.util.Iterator;

/**
 * This interface for control elements in custom collection
 * @see MyList
 * @version 1.0
 */
public interface MyList<E> {
    boolean add(E e);

    E get(int index);

    boolean remove(int index);

    boolean contains(E e);

    int size();

    Iterator<E> iterator();


}
