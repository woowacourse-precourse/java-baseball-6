package baseball;

import java.util.Arrays;
import java.util.regex.Pattern;

public class InputManager {

    private static final Pattern inputValidator = Pattern.compile("^([1-9]{3})$");

    public static int[] parseInput(String inputString) throws IllegalArgumentException {
        if(!inputValidator.matcher(inputString).matches()) {
            throw new IllegalArgumentException();
        }

        int[] userNumber = (int[]) Arrays.stream(inputString.split("")).mapToInt(
                element -> Integer.parseInt(element)
        ).toArray();

        if(doContainDupNumber(userNumber)) {
            throw new IllegalArgumentException();
        }
        return userNumber;
    }

    public static boolean validateRestartInput(String input) {
        return input.equals("1") || input.equals("2");
    }

    private static boolean doContainDupNumber(int[] input) {
        boolean[] numberFlag = new boolean[10];
        for(int i = 0; i < 3; i++) {
            if(numberFlag[input[i]]) {
                return true;
            }
            numberFlag[input[i]] = true;
        }
        return false;
    }
}
