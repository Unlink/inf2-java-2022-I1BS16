package sk.uniza.fri.inf.zoo;

/**
 * 26. 4. 2022 - 8:09
 *
 * @author Michal
 */
public class Excel {

    public static <T> T IF(boolean condition, T a, T b) {
        return condition ? a : b;
    }

    public static <T extends Number & Comparable<T>> T Max(T... values) {
        T maxVal = null;
        for (T value : values) {
            if (maxVal == null || value.compareTo(maxVal) > 0) {
                maxVal = value;
            }
        }
        return maxVal;
    }

}
