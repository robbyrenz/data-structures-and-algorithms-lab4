/**
 * @author Robby Renz Abeysinghe
 * Student Number: 3073208
 * Answer 2 of Lab 4
 */

public interface List<E> {
    int size();
    boolean isEmpty();
    E get(int i) throws IndexOutOfBoundsException;
    E set(int i, E e) throws IndexOutOfBoundsException;
    void add(int i, E e) throws IndexOutOfBoundsException;
    E remove(int i) throws IndexOutOfBoundsException;
}