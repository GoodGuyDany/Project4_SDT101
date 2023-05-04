// #2 implementation
import java.util.ArrayList;
public class Main2 {
    // Creating a recursive method for linear search #2.1
    public static int recLinearSearch(ArrayList<String> list, String key, int beginIdx, int endIdx) {
        if (beginIdx > endIdx || beginIdx < 0 || endIdx >= list.size()) { // Base condition, checking if the search request is viable or not
            return -1;
        }

        if (list.get(beginIdx).equals(key)) { // Comparing the keyword to beginIdx in the list
            return beginIdx;
        }

        return recLinearSearch(list, key, beginIdx + 1, endIdx); // Using recursion to go through the method again but this time with a greater beginIdx
    }
    // Creating a recursive method for binary search #2.2
    public static int recursiveBinarySearch(int[] a, int search, int low, int high) {
        if (low > high) { // Checking if the search request is viable
            return -1;
        }
        int mid = (low + high) / 2; // Getting the mid value
        if (a[mid] == search) { // Checking if the mid value is equal to key search value
            return mid;
        } else if (a[mid] < search) { // Going through the upper part of the array
            return recursiveBinarySearch(a, search, mid + 1, high);
        } else {
            return recursiveBinarySearch(a, search, low, mid - 1); // Going through the lower part of the array
        }
    }
    // Creating a method for binary search #2.2
    public static int binarySearch(int[] a, int searchValue) {
        int low = 0; // Initializing low value
        int high = a.length - 1; // Initializing high value
        while (low <= high) { // Going through the array until it ends
            int mid = (low + high) / 2; // Getting the mid value
            if (a[mid] == searchValue) { // Checking if the mid value is equal to searchValue
                return mid;
                // If not equal, getting new mid and low values
            } else if (a[mid] < searchValue) {
                low = mid + 1; // Increasing the low value
            } else {
                high = mid - 1; // Decreasing the high value
            }
        }
        return -1; // Returning -1 if not found
    }
    // Main method
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(); // Initializing an ArrayList of String objects
        // Adding items to the list
        list.add("Donut");
        list.add("Ketchup");
        list.add("Mayonnaise");
        list.add("Mustard");
        list.add("Egg");
        list.add("Bacon");
        int index = recLinearSearch(list, "Egg", 0, 5); // Going through the ArrayList "list" looking for keyword "Egg" index should be 4
        System.out.println("The value of searchIndex in recLinearSearch is: " + index); // Printing out the index of Key in list
        System.out.println(); // Making space
        int[] b = {2, 3, 5, 10, 16, 24, 32, 48, 96, 120, 240, 360, 800, 1600}; // Initializing a new array of ints
        int searchIndex = recursiveBinarySearch(b, 150, 0, b.length - 1); // Going through the list and looking for a certain value, in this case it's 120
        System.out.println("The value of searchIndex in recursiveBinarySearch is: " + searchIndex); // Printing out the index value of the value we're searching for
//      Trace of recursiveBinarySearch #2.3:
//
//      The method call in main:
//      a = {2, 3, 5, 10, 16, 24, 32, 48, 96, 120, 240, 360, 800, 1600}
//      int index = recursiveBinarySearch(a, 10, 0, a.length-1);
//
//      1st call:
//      low = 0, high = 13, middle.index = 6, middle.value = 32, search.value = 10
//      middle.value =! search.value, middle.value > search.value
//
//      2nd call:
//      low = 0, high = 5, middle.index = 2, middle.value = 5, search.value = 10
//      middle.value =! search.value, middle.value < search.value
//
//      3rd call:
//      low = 3, high = 5, middle.index = 4, middle.value = 16, search.value = 10
//      middle.value =! search.value, middle.value > search.value
//
//      4th call:
//      low = 3, high = 3, middle.index = 3, middle.value = 10, search.value = 10
//      middle.value == search.value, search.index = 3
//
//      Trace of recursiveBinarySearch #2.4:
//      a = {2, 3, 5, 10, 16, 24, 32, 48, 96, 120, 240, 360, 800, 1600}
//      int index = recursiveBinarySearch(b, 150, 0, a.length-1);
//
//      1st call:
//      low = 0, high = 13, middle.index = 6, middle.value = 32, search.value = 150
//      middle.value =! search.value, middle.value < search.value
//
//      2nd call:
//      low = 7, high = 13, middle.index = 10, middle.value = 240, search.value = 150
//      middle.value =! search.value, middle.value > search.value
//
//      3rd call:
//      low = 7, high = 9, middle.index = 8, middle.value = 96, search.value = 150
//      middle.value =! search.value, middle.value < search.value
//
//      4th call:
//      low = 9, high = 9, middle.index = 9, middle.value = 120, search.value = 150
//      middle.value =! search.value, middle.value < search.value
//
//      5th call:
//      low = 10, high = 9
//      return -1 (low > high, the value we're searching for doesn't exist)

        System.out.println(); // Making space
        int[] c = {1,2,3,4,5,6,7,8,9,10,11}; // Initializing a new int array
        int searchIndex2 = binarySearch(c, 9); // Going through the array using regular binary search
        System.out.println("The value of searchIndex in binarySearch is: " + searchIndex2); // Printing out the index value of the value we're searching for
    }
}
// Explanations for #3:
// #3.1
//In order to demonstrate that f(n) = 2.5n + 4 is O(n) according to the formal definition of Big O, we must demonstrate that C and n0 exist such that:
//
//        For any n > n0, |f(n)| = C|n
//
//
//        Starting off, let's pick a function g(n) that is known to be O(n). To keep things simple, let's choose g(n) = n.
//
//        Then, we must identify C and n0 constants such that:
//
//        For any n > n0, |f(n)| = C|n
//
//        By replacing f(n) and g(n), we obtain:
//
//        |2.5n + 4| <= C|n|
//
//        This inequality can be condensed as follows:
//
//        -2.5n - 4 <= Cn <= 2.5n + 4
//
//        -2.5n - 4 <= 3n <= 2.5n + 4
//
//        2.5n + 4 >= -3n >= -2.5n - 4
// #3.4
//        The modulo operation, which determines whether a number in the input list is even or odd, is the algorithm's key operation (n% 2 == 0). The for loop's
//        execution involves doing this procedure on each integer in the input list. The operation that decides whether an integer should be added to the
//        pEvenList or pOddList is the one that is carried out the most frequently while the algorithm is running. As a result, this algorithm's core operation—the
//        modulo operation—is crucial for determining the worst-case time complexity.
// #3.5
//       The crucial process occurs in the for loop's if statement, where the modulo operation is used to determine whether the current entry in the pList is even or odd.
//       The function f(n), where n is the size of pList, is equal to n since this operation is carried out once for each element in pList.
//       Given that the number of operations is inversely proportional to the size of the input, the split() method's worst-case time complexity is O(n).
// #3.6
//        No, whether or whether the elements in pList are sorted in ascending order has no impact on how long the split() procedure takes to complete.
//        This is so that the method's time complexity may be calculated based on the number of entries in pList rather than their sort order.
//        The essential process of determining whether each element in pList is even or odd and adding it to the relevant ArrayList remains the same.
//        Split() has an O(n) worst-case time complexity, where n is the size of the pList.