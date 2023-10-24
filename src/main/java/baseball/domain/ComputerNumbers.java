package baseball.domain;

import java.util.List;

public class ComputerNumbers {

    private final List<Integer> numbers;

    public ComputerNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public void compare(int playerNumber, int indexOfPlayerNumber) {
        for (int indexOfComputerNumber = 0; indexOfComputerNumber < numbers.size(); indexOfComputerNumber++) {
            int computerNumber = numbers.get(indexOfComputerNumber);
            if (computerNumber == playerNumber) {
                ballCount(indexOfComputerNumber, indexOfPlayerNumber);
            }
        }
    }

    private void ballCount(int indexOfComputerNumber, int indexOfPlayerNumbers) {
        if (indexOfPlayerNumbers == indexOfComputerNumber) {
            BallCounter.countStrike();
            return;
        }
        BallCounter.countBall();
    }
}
