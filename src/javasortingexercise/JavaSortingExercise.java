package javasortingexercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Caspian Maclean 30039802
 *
 *
 * Question 3 – You are required to make a list of different annual salaries for
 * payroll in whole numbers (integers) that will then need to be sorted, you
 * should have alternate methods of sorting so that payroll can decide on which
 * method they would like to use. You need to create an application that creates
 * lists of integers between 1 and 10 million. Your application must have the
 * ability to sort in three different styles with timers to indicate the speed
 * at which this happens you must have at least 100,000 items in your list as
 * this the future business strategy to employ at least this many staff. The
 * current system is only able to handle 12 staff. Only 1 sorting technique may
 * use the inbuilt sorting the rest you must write yourself. In addition, you
 * must list the advantages and disadvantages of each algorithm. Your sorting
 * algorithm must have a comparator.
 *
 *
 */
public class JavaSortingExercise {

    // static private int numSalaries  = 10;
    // static int[] salaries = new int[numSalaries];
    // Creates a list of integers between 1 and 10 million
    public static Integer[] initialiseSalaries() {
        int numSalaries = 10;
        Integer[] salaries = new Integer[numSalaries];

        //int maxSalary = 10000000;
        // Smaller value is easier to read during development
        int maxSalary = 100;
        for (int i = 0; i < numSalaries; i++) {
            salaries[i] = 1 + (int) (Math.random() * maxSalary);
        }
        return salaries;
    }

    public static void swap(Integer[] list, int firstIndex, int secondIndex) {
        Integer temp = list[firstIndex];
        list[firstIndex] = list[secondIndex];
        list[secondIndex] = temp;

    }

    public static void selectionSort(Integer[] list, Comparator<Integer> comparator) {
        for (int locationForSmallest = 0; locationForSmallest < list.length - 1;
                locationForSmallest++) {
            for (int i = locationForSmallest + 1; i < list.length; i++) {
                if (comparator.compare(list[i], list[locationForSmallest]) < 0) {
                    // Item at i should come first, swap it into locationForSmallest
                    swap(list, i, locationForSmallest);
                }
            }
        }
    }

    // quickSortRecursive and partition are based on pseudocode
    // from https://www.geeksforgeeks.org/quick-sort/
    
    /* This function takes last element as pivot, places
   the pivot element at its correct position in sorted
    array, and places all smaller (smaller than pivot)
   to left of pivot and all greater elements to right
   of pivot */
    // It returns the index of the pivot in its correct location.
    public static int partition(Integer[] list, Comparator<Integer> comparator,
            int firstIndex, int lastIndex) {
        Integer pivotValue = list[lastIndex];
        int i = firstIndex - 1;
        for (int j = firstIndex; j <= lastIndex - 1; j++) {
            if (comparator.compare(list[j], pivotValue) < 0) {
                i++;
                swap(list, i, j);
            }
        }
        swap(list, i+1, lastIndex);
        return i+1;
    }
    
    public static void quickSortRecursive(Integer[] list, Comparator<Integer> comparator,
            int firstIndex, int lastIndex) {
        if (firstIndex < lastIndex) {
            int partitionIndex = partition(list, comparator, firstIndex, lastIndex);
            quickSortRecursive(list, comparator, firstIndex, partitionIndex - 1);
            quickSortRecursive(list, comparator, partitionIndex + 1, lastIndex);
        }
    }

    public static void quickSort(Integer[] list, Comparator<Integer> comparator) {
        // Get the index for the first and last elements
        int firstIndex = 0;
        int lastIndex = list.length - 1;
        quickSortRecursive(list, comparator, firstIndex, lastIndex);
    }

    public static void main(String[] args) {
        System.out.println("Start");

        Comparator<Integer> comparator = new AscendingIntegerComparator();

        // Create 3 identical lists for testing the sort methods, and
        // keep another copy unsorted.
        Integer[] salariesUnsorted = initialiseSalaries();
        Integer[] salaries1 = salariesUnsorted.clone();
        Integer[] salaries2 = salariesUnsorted.clone();
        Integer[] salaries3 = salariesUnsorted.clone();

        Arrays.sort(salaries1, comparator);
        selectionSort(salaries2, comparator);
        quickSort(salaries3, comparator);

        System.out.println("Initial numbers");
        for (int i : salariesUnsorted) {
            System.out.print(i + " ");
        }
        System.out.println("");

        System.out.println("Make sure these are sorted");
        for (int i : salaries1) {
            System.out.print(i + " ");
        }
        System.out.println("");
        for (int i : salaries2) {
            System.out.print(i + " ");
        }
        System.out.println("");
        for (int i : salaries3) {
            System.out.print(i + " ");
        }
        System.out.println("");

    }

}
