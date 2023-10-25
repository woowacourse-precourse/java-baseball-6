package baseball.Utils;

public class Converter {
    public int[] convertUserChooseInputToInt(String input) {
        if (!input.matches("\\d{3}")) {
            throw new IllegalArgumentException();
        }

        int[] output = new int[3];
        for (int i = 0; i < 3; i++) {
            output[i] = Integer.parseInt(input.substring(i, i + 1));
        }

        return output;
    }

    public int convertUserInputToInt(String input) {
        if (!(input.equals("1") || input.equals("2"))) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(input);
    }
}
