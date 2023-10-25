package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class ComputerPlayer {
    private int[] numbers;

    public ComputerPlayer() {
        numbers = new int[3];
    }

    public int[] generateRandomNumber() {
        for (int i = 0; i < 3; i++) {
            numbers[i] = Randoms.pickNumberInRange(1, 9);
        }
        return numbers;
    }

    public int[] checkGuess(int[] userGuess, int[] computerNumber) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < 3; i++) {
            if (userGuess[i] == computerNumber[i]) {
                strikes++;
            } else if (contains(userGuess[i], computerNumber)) {
                balls++;
            }
        }

        return new int[] { strikes, balls };
    }

    public void displayResult(int[] result) {
        int strikes = result[0];
        int balls = result[1];

        if (strikes > 0) {
            System.out.println(strikes + " 스트라이크");
        }

        if (balls > 0) {
            System.out.println(balls + " 볼");
        }

        if (strikes == 0 && balls == 0) {
            System.out.println("Nothing");
        }
    }

    private boolean contains(int digit, int[] numberArray) {
        for (int number : numberArray) {
            if (number == digit) {
                return true;
            }
        }
        return false;
    }
}
