package javasortingexercise;

import java.util.Comparator;

/**
 *
 * @author Caspian Maclean 30039802
 */
public class AscendingIntegerComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o1 - o2; // Converts from Integer to int as required.
    }
}
