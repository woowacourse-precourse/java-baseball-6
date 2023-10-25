package baseball;

import java.util.List;

/**
 * 볼 갯수, 스트라이크 갯수를 파악하여 게임 결과를 파악 한다.
 */

public class NumberChecker {
    List<Integer> computerNumbers;

    public static NumberChecker setRandomNumbers(List<Integer> computerNumbers) {
        return new NumberChecker(computerNumbers);
    }

    NumberChecker(List<Integer> computerNumbers) {
        this.computerNumbers = computerNumbers;
    }

    public int getBallCount(List<Integer> inputNumbers) {
        int ballCount = 0;
        for(int i = 0; i < computerNumbers.size(); i++) {
            if(isBall(i, inputNumbers)) {
                ballCount++;
            }
        }

        return ballCount;
    }

    private boolean isBall(int current, List<Integer> inputNumbers) {
        for(int j = 0; j < inputNumbers.size(); j++) {
            if(current == j) {
                continue;
            }

            if(computerNumbers.get(current).equals(inputNumbers.get(j))) {
                return true;
            }
        }

        return false;
    }

    public int getStrikeCount(List<Integer> inputNumbers) {
        int strikeCount = 0;

        for(int i = 0; i < computerNumbers.size(); i++) {
            if(computerNumbers.get(i).equals(inputNumbers.get(i))) {
                strikeCount++;
            }
        }

        return strikeCount;
    }
}
