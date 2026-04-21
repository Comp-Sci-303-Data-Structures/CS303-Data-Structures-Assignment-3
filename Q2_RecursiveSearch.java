import java.util.ArrayList;
import java.util.Arrays;

/*
 *Question 2:
 * Recursive linear search that finds the LAST occurrence of a target
 * in an ArrayList (not the first).
 *
 *   - Base case : index < 0  → target not found, return -1
 *   - Recursive step: search from the END of the list toward the front.
 */
public class Q2_RecursiveSearch {

    /**
     * Public entry point – starts the search from the last index.
     *
     * @param list   the ArrayList to search
     * @param target the value to look for
     * @param <T>    telement type (must implement equals)
     * @return index of the last occurrence, or -1 if not found
     */
    public static <T> int lastOccurrence(ArrayList<T> list, T target) {
        if (list == null || list.isEmpty()) return -1;
        // recursion begins from last index
        return recursiveSearch(list, target, list.size() - 1);
    }

    private static <T> int recursiveSearch(ArrayList<T> list, T target, int index) {
        // Base case: we've walked past the beginning -> not found
        if (index < 0) {
            return -1;
        }

        // If the current element matches target, return this index.
        if (list.get(index).equals(target)) {
            return index;
        }

        // Recursive step: move one position to the left
        return recursiveSearch(list, target, index - 1);
    }


    // main – demonstrates several test cases

    public static void main(String[] args) {

        // Test 1: integer list with multiple occurrences of the target
        ArrayList<Integer> intList = new ArrayList<>(
                Arrays.asList(3, 7, 1, 9, 7, 4, 7, 2, 5));
        System.out.println("=== Q2 Recursive Last-Occurrence Search ===\n");
        System.out.println("List : " + intList);
        int target = 7;
        int result = lastOccurrence(intList, target);
        System.out.println("Last occurrence of " + target + " → index " + result);
        // expected: 6  (0-based)

        // Test 2: target appears only once
        target = 9;
        result = lastOccurrence(intList, target);
        System.out.println("Last occurrence of " + target + " → index " + result);
        // expected: 3

        // Test 3: target not present
        target = 99;
        result = lastOccurrence(intList, target);
        System.out.println("Last occurrence of " + target + " → index " + result);
        // expected: -1

        // Test 4: target is the very first element only
        target = 3;
        result = lastOccurrence(intList, target);
        System.out.println("Last occurrence of " + target + " → index " + result);
        // expected: 0

        // Test 5: String ArrayList
        ArrayList<String> strList = new ArrayList<>(
                Arrays.asList("apple", "banana", "apple", "cherry", "apple", "date"));
        System.out.println("\nList : " + strList);
        String word = "apple";
        int wordResult = lastOccurrence(strList, word);
        System.out.println("Last occurrence of \"" + word + "\" → index " + wordResult);
        // expected: 4
    }
}