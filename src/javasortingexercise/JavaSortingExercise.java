/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasortingexercise;

import java.util.ArrayList;
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
    public static int[] initialiseSalaries() {
        int numSalaries  = 10;
        int[] salaries = new int[numSalaries];
        int maxSalary = 10000000;
        for (int i=0;i<numSalaries; i++) {
            salaries[i] = 1+(int)(Math.random()*maxSalary);
        }  
        return salaries;
    }
    public static void main(String[] args) {
        
        // Create 3 identical lists for testing the sort methods.
        int[] salaries1 = initialiseSalaries();
        int[] salaries2 = salaries1.clone();
        int[] salaries3 = salaries1.clone();
        
        
        
    }

}
