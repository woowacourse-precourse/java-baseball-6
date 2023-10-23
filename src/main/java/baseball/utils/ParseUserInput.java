package baseball.utils;


public class ParseUserInput {
    public int[] getUserNumbers(String userInput, int size) throws IllegalArgumentException {
        return checkInput(userInput, size);
    }

    private static int[] checkInput(String userInput, int size) throws IllegalArgumentException {
        try {
            if (userInput.length() < size) {

            }
            return processInput(userInput, size);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException();
        }
    }

    private static int[] processInput(String userInput, int size) throws IllegalArgumentException {
        String[] strUserNums = userInput.split("");
        int[] userNums = new int[size];
        try {
            for (int i = 0; i < strUserNums.length; i++) {
                userNums[i] = Integer.parseInt(strUserNums[i]);
                if (!checkRange(userNums[i])) {
                    throw new IllegalArgumentException();
                }
            }
        } catch (NumberFormatException i) {
            throw new IllegalArgumentException();
        }
        return userNums;
    }

    private static boolean checkRange(int userNums) {
        return 0 <= userNums && userNums <= 9;
    }

}
