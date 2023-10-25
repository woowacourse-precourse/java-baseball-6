package baseball.model;

import java.util.Arrays;

public class Game {
    private static final int SIZE = 3;
    private static int ball;
    private static int strike;

    public static void initializeCounts() {
        ball = 0;
        strike = 0;
    }

    public static int[] generateHint(String userInput, int[] pickedNumbers) {
        initializeCounts();
        ball = countBalls(userInput, pickedNumbers);
        strike = countStrikes(userInput, pickedNumbers);
        return new int[]{ball, strike};
    }

    public static int countBalls(String userInput, int[] pickedNumbers) {
        int count = 0;
        String pickedString = Arrays.toString(pickedNumbers);
        for (int i = 0; i < SIZE; i++) {
            char currentDigit = userInput.charAt(i);
            if (pickedString.contains(String.valueOf(currentDigit))) {
                count++;
            }
        }
        return count;
    }

    public static int countStrikes(String userInput, int[] pickedNumbers) {
        int count = 0;
        for (int i = 0; i < SIZE; i++) {
            if (pickedNumbers[i] == userInput.charAt(i) - '0') {
                count++;
                ball--;
            }
        }
        return count;
    }

    public static boolean isGameWon() {
        return strike == SIZE;
    }
}

