package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerPlayer {
    private int[] numbers;

    public ComputerPlayer() {
        numbers = new int[3];
    }

    public int[] generateRandomNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        for (int i = 0; i < 3; i++) {
            numbers[i] = computer.get(i);
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

        if (balls > 0) {
            System.out.print(balls + "볼 ");
        }
        if (strikes > 0) {
            System.out.print(strikes + "스트라이크");
        }

        if (strikes == 0 && balls == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
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
