package baseball.domain;

import java.util.List;

/**
 * 컴퓨터가 선택한 수를 관리하는 역할을 수행한다.
 */
public class ComputerNumbers {

    private static final int INITIAL_INDEX = 0;

    private final List<Integer> numbers;

    public ComputerNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    /**
     * 플레이어의 숫자와 위치를 받아, 컴퓨터의 모든 숫자와 비교한다.
     * 숫자가 같은 경우 그 숫자의 위치를 통해 볼과 스트라이크의 개수를 각각 증가시킨다.
     */
    public void compare(int playerNumber, int indexOfPlayerNumber) {
        for (int indexOfComputerNumber = INITIAL_INDEX; indexOfComputerNumber < numbers.size(); indexOfComputerNumber++) {
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
