import java.util.LinkedList;

/**
 * Question 3:
 *
 * Because LinkedList supports index-based get/set in O(n) time, the overall
 * complexity is O(n²)
 */
public class Q3_InsertSort {

    /**
     * Sorts a LinkedList<Integer> in ascending order using insertion sort.
     * Modifies the list in-place.
     *
     * @param list the LinkedList to sort
     */
    public static void insertionSort(LinkedList<Integer> list) {
        int n = list.size();

        // Outer loop: consider each element from index 1 onward
        for (int i = 1; i < n; i++) {

            int key = list.get(i); // element to be inserted into sorted portion
            int j   = i - 1;       // start comparing with the element just before i

            // Inner loop: shift elements that are greater than key one step to the right
            while (j >= 0 && list.get(j) > key) {
                list.set(j + 1, list.get(j)); // shift element right
                j--;
            }

            // Place key in its correct sorted position
            list.set(j + 1, key);
        }
    }

    /**
     * Prints the contents of the linked list in a readable format.
     *
     * @param list   the list to display
     * @param label  a label printed before the list contents
     */
    public static void printList(LinkedList<Integer> list, String label) {
        System.out.print(label + ": [");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i < list.size() - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    // ---------------------------------------------------------------
    // main – demonstrates insertion sort on several linked lists
    // ---------------------------------------------------------------
    public static void main(String[] args) {
        System.out.println("=== Q3 Insertion Sort on LinkedList ===\n");

        // Test 1: unsorted list
        LinkedList<Integer> list1 = new LinkedList<>();
        int[] values1 = {64, 25, 12, 22, 11, 90, 3, 47, 55, 8};
        for (int v : values1) list1.add(v);
        printList(list1, "Before sort");
        insertionSort(list1);
        printList(list1, "After  sort");

        System.out.println();

        // Test 2: already sorted list
        LinkedList<Integer> list2 = new LinkedList<>();
        int[] values2 = {1, 2, 3, 4, 5};
        for (int v : values2) list2.add(v);
        printList(list2, "Before sort (already sorted)");
        insertionSort(list2);
        printList(list2, "After  sort                 ");

        System.out.println();

        // Test 3: reverse-sorted list (worst case for insertion sort)
        LinkedList<Integer> list3 = new LinkedList<>();
        int[] values3 = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        for (int v : values3) list3.add(v);
        printList(list3, "Before sort (reverse order)");
        insertionSort(list3);
        printList(list3, "After  sort                ");

        System.out.println();

        // Test 4: list with duplicate values
        LinkedList<Integer> list4 = new LinkedList<>();
        int[] values4 = {5, 3, 5, 1, 3, 2, 5};
        for (int v : values4) list4.add(v);
        printList(list4, "Before sort (with duplicates)");
        insertionSort(list4);
        printList(list4, "After  sort                  ");
    }
}
