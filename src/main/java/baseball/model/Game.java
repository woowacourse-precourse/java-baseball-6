package baseball.model;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Game {
    public static final int STRIKE = 1;
    public static final int BALL = 0;
    private final char[] randNumber;

    private Game() {
        int[] array = new int[10];
        StringBuilder sb = new StringBuilder();
        while (sb.length() != 3) {
            int pickNumber = pickNumberInRange(1, 9);
            if (array[pickNumber] == 0) {
                array[pickNumber] = 1;
                sb.append(pickNumber);
            }
        }
        this.randNumber = sb.toString().toCharArray();
    }

    private Game(char[] randNumber) {
        this.randNumber = randNumber;
    }

    public static Game createRandomNumber() {
        return new Game();
    }

    public static Game createRandomNumberForInput(char[] input) {
        return new Game(input);
    }

    public int[] checkScoreResult(String input) {
        int[] array = new int[2];
        char[] computerNumber = this.randNumber;
        char[] inputNumber = input.toCharArray();

        for (int i = 0; i < inputNumber.length; i++) {
            for (int j = 0; j < computerNumber.length; j++) {
                countStrikeAndBall(array, computerNumber, inputNumber, i, j);
            }
        }

        return array;
    }

    private static void countStrikeAndBall(int[] array, char[] computerNumber, char[] inputNumber, int i, int j) {
        if (inputNumber[i] == computerNumber[j]) {
            if (i == j) {
                array[STRIKE]++;
            } else {
                array[BALL]++;
            }
        }
    }

    public char[] getRandNumber() {
        return randNumber;
    }
}
