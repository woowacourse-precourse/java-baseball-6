package baseball.data;

import java.util.*;

public class BaseballNumbers {
    private List<Integer> numberList;

    public BaseballNumbers(List<Integer> numberList) {
        validateLength(numberList);
        validateDuplicate(numberList);
        this.numberList = numberList;
    }

    public GameResult getResult(BaseballNumbers OtherPlayerBallNumbers) {
        int strike = 0;
        int ball = 0;

        for (int index = 0; index < 3; index++) {
            strike += OtherPlayerBallNumbers.checkStrike(index, numberList.get(index));
            ball += OtherPlayerBallNumbers.checkBall(index, numberList.get(index));
        }

        return new GameResult(strike, ball);
    }

    public int checkStrike(int index, int number) {
        if (numberList.get(index) == number) {
            return 1;
        }
        return 0;
    }

    public int checkBall(int index, int number) {
        if ((checkStrike(index, number) != 1)
                && (numberList.contains(number))) {
            return 1;
        }
        return 0;
    }

    private void validateLength(List<Integer> numberList){
        if (numberList.size() != 3) {
            throw new IllegalArgumentException("야구 게임의 숫자는 3개여야 합니다!");
        }
    }

    private void validateDuplicate(List<Integer> numberList) {
        Set<Integer> uniqueNumbers = new HashSet<>(numberList);
        if (uniqueNumbers.size() != 3) {
            throw new IllegalArgumentException("야구 게임의 수들은 고유 해야 합니다!");
        }
    }
}