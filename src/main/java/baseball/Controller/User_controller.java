package baseball.Controller;

public class User_controller {

    public int[] UserInput(String input, int size) throws IllegalArgumentException {
        checkSize(input, size);
        return getNum(input, size);
    }

    private void checkSize(String input, int size) throws IllegalArgumentException {
        if (input.length() != size) {
            throw new IllegalArgumentException();
        }
    }

    private int[] getNum(String input, int size) throws IllegalArgumentException {
        int[] parseInt = new int[size];

        for (int i = 0; i < input.length(); i++) {
            if (!('0' <= input.charAt(i) && input.charAt(i) <= '9')) {
                throw new IllegalArgumentException();
            }
            parseInt[i] = input.charAt(i) - '0';
        }
        return parseInt;
    }
}
