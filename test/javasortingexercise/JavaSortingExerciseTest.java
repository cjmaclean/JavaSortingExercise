/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasortingexercise;

import java.util.Comparator;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Caspian Maclean 30039802
 * 
 * 17/8/2021
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
 * algorithm must have a comparator
 *
 */
public class JavaSortingExerciseTest {

    public JavaSortingExerciseTest() {
    }

    /**
     * Test of initialiseSalaries method, of class JavaSortingExercise.
     */
    @Test
    public void testInitialiseSalaries() {
        System.out.println("initialiseSalaries");
        Integer[] result = JavaSortingExercise.initialiseSalaries();

        // Allow a visual check to make sure they look random.
        System.out.println("First few elements: " + result[0] + "," + result[1]
                + "," + result[2] + "," + result[3]);
        assertTrue(result.length >= 100000);

    }

    /**
     * Test of swap method, of class JavaSortingExercise.
     */
    @Test
    public void testSwap() {
        System.out.println("swap");
        Integer[] list = {10, 20, 30};

        Integer[] unchangedList = {10, 20, 30};

        Integer[] expectedResult = {30, 20, 10};

        // Should not change when swapping a location with itself.
        JavaSortingExercise.swap(list, 1, 1);
        assertArrayEquals(list, unchangedList);

        // Normal swap
        JavaSortingExercise.swap(list, 0, 2);
        assertArrayEquals(expectedResult, list);
    }

    /**
     * Test of selectionSort method, of class JavaSortingExercise.
     */
    @Test
    public void testSelectionSort() {
        System.out.println("selectionSort");
        Integer[] list = {40, 10, 30, 20};
        Integer[] expectedResult = {10, 20, 30, 40};

        Comparator<Integer> comparator = new AscendingIntegerComparator();
        JavaSortingExercise.selectionSort(list, comparator);
        assertArrayEquals(expectedResult, list);
    }

    /**
     * Test of partition method, of class JavaSortingExercise.
     */
    @Test
    public void testPartition() {
        System.out.println("partition");

        Integer[] list = {100, 61, 62, 63, 21, 22, 23, 50, 1};

        Comparator<Integer> comparator = new AscendingIntegerComparator();

        // partition all except the first and last element.
        int firstIndex = 1;
        int lastIndex = 7;
        int expReturnResult = 4; // location of partition element, the 50.
        Integer[] expectedListResult = {100, 21, 22, 23, 50, 62, 63, 61, 1};
        // First and last elements are unmoved, others are partitioned around the 50,
        // exact order found by running the code.

        int result = JavaSortingExercise.partition(list, comparator, firstIndex, lastIndex);
        assertArrayEquals(expectedListResult, list);

        assertEquals(expReturnResult, result);

    }

    /**
     * Test of quickSort method, of class JavaSortingExercise.
     */
    @Test
    public void testQuickSort() {
        System.out.println("quickSort");

        Integer[] list = {40, 10, 30, 20};
        Integer[] expectedResult = {10, 20, 30, 40};

        Comparator<Integer> comparator = new AscendingIntegerComparator();
        JavaSortingExercise.quickSort(list, comparator);
        assertArrayEquals(list, expectedResult);

    }

}
