package baseball;

import java.util.List;

public class ArrayUtils {

    public int[] stringToIntArray(String stringNumbers) {
        int[] numbers = new int[3];
        for (int index = 0; index < 3; index++) {
            numbers[index] = stringNumbers.charAt(index) - '0';
        }
        return numbers;
    }

    public int[] listToIntArray(List<Integer> listNumbers) {
        int[] numbers = new int[3];
        for (int index = 0; index < 3; index++) {
            numbers[index] = listNumbers.get(index);
        }
        return numbers;
    }
}
