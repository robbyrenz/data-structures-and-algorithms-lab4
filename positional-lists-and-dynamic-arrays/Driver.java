/**
 * @author Robby Renz Abeysinghe
 * Student Number: 3073208
 * Answer 1 of Lab 4
 */

import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) {
        LinkedPositionalList<Integer> list = new LinkedPositionalList<>();
        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.addLast(7);
        list.addLast(8);
        list.addLast(9);
        list.addLast(10);

        Position<Integer> cursor = list.first();
        display(1, list, cursor);

        for (int i = 0; i < 4; i++) {
            cursor = list.after(cursor);
        }
        display(2, list, cursor);

        list.addBefore(cursor, 8);
        list.addAfter(cursor, 2);
        display(3, list, cursor);

        for (int i = 0; i < 2; i++)
            cursor = list.before(cursor);
        display(4, list, cursor);

        Position after = list.after(cursor);
        list.set(after, 0);
        Position before = list.before(cursor);
        /* int foo = */ list.remove(before);
        // System.out.println(foo);
        display(5, list, cursor);

        System.out.println("\nDynamic Arrays: Showing how the size increases and decreases...");
        DynamicArray<String> newList = new DynamicArray<>(2);
        newList.add(0, "Harry");
        newList.add(1, "Potter");
        System.out.println(newList.size());
        newList.add(2, "Tom");
        newList.add(3, "Marvolo");
        System.out.println(newList.size());
        newList.add(4, "Riddle");
        System.out.println(newList.size());
        newList.add(5, "Hegwig");
        System.out.println(newList.size());
        newList.add(6, "Remus");
        System.out.println(newList.size());
        newList.add(7, "Ron");
        newList.add(8, "Ginny");
        System.out.println(newList.size());
        newList.remove(8);
        newList.remove(0);
        newList.remove(1);
        newList.remove(2);
        System.out.println(newList.size());
    }

    // method to display the LinkedPositionalList contents & the Position element
    public static void display(int i, LinkedPositionalList<Integer> list, Position cursor) {
        System.out.println("Answer " + i + ":\n" + list + "\n" + cursor.getElement() + "\n");
    }
}
