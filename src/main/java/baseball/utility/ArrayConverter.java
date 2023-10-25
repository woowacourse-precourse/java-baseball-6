package baseball.utility;

public class ArrayConverter {

    public static int[] toIntArray(String input) {
        int[] array = new int[input.length()];

        for (int i = 0; i < input.length(); i++) {
            array[i] = input.charAt(i) - '0';
        }

        return array;
    }

}
