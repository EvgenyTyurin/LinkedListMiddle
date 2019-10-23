import java.util.Iterator;
import java.util.LinkedList;

/**
 * Find the middle of Linked list by 3 methods: strait, fast and slow pointers,
 * recursion.
 * Oct 2019 EvgenyT
 */

public class LinkedListMiddle {

    // Vars for recursive methods
    static int listMid, listCount = 1;

    public static void main(String[] args) {
        // Linked list
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2); // Middle is here
        linkedList.add(3);

        // Strait method if we know size of list
        System.out.println(linkedList.get(linkedList.size() / 2)); //  = 2

        // Method with fast and slow pointers
        Iterator<Integer> fastIterator = linkedList.iterator();
        Iterator<Integer> slowIterator = linkedList.iterator();
        while (true) {
            // Fast pointer moves by two steps
            if (fastIterator.hasNext() && fastIterator.next() != null &&
                    fastIterator.hasNext()) {
                fastIterator.next();
            }
            else {
                break;
            }
            // Slow pointer moving 1/2 speed of fast
            slowIterator.next();
        }
        // When the fast reaches end, slow is at the middle
        System.out.println(slowIterator.next()); // = 2

        // Recursive method
        recursiveIteration(linkedList.iterator());
    }

    // Recursive method is a bit funny
    static void recursiveIteration(Iterator<Integer> iterator) {
        int i;
        // Recursive iteration to the end
        if (iterator.hasNext()) {
            i = iterator.next();
            // Counting elements
            listCount++;
            recursiveIteration(iterator);
        } else {
            // End reached - calculate middle if list
            listMid = (listCount) / 2;
            return;
        }
        // Return from recursion - counting elements back
        listCount--;
        // If mid position reached - show element
        if (listCount == listMid)
            System.out.println(i); // = 2
    }

}
