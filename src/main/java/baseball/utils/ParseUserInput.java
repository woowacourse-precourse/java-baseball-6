package baseball.utils;


public class ParseUserInput {

    public int[] getUserNumbers(String userInput, int size) throws IllegalArgumentException {
        return parseInput(userInput, size);
    }


    private static int[] parseInput(String userInput, int size) throws IllegalArgumentException {
        validateLength(userInput, size);
        return validateConvertible(userInput, size);
    }

    private static void validateLength(String userInput, int size) {
        if (userInput.length() != size) {
            throw new IllegalArgumentException();
        }
    }


    private static int[] validateConvertible(String userInput, int size) {
        try {
            return convertStringToInt(userInput, size);
        } catch (NumberFormatException i) {
            throw new IllegalArgumentException();
        }
    }


    private static int[] convertStringToInt(String userInput, int size) {
        String[] strUserNums = userInput.split("");
        int[] userNums = new int[size];
        for (int i = 0; i < strUserNums.length; i++) {
            userNums[i] = Integer.parseInt(strUserNums[i]);
            validateNumberRange(userNums, i);
        }
        return userNums;
    }

    private static void validateNumberRange(int[] userNums, int i) {
        if (!checkNumberRange(userNums[i])) {
            throw new IllegalArgumentException();
        }
    }


    private static boolean checkNumberRange(int userNums) {
        return 0 <= userNums && userNums <= 9;
    }
}
