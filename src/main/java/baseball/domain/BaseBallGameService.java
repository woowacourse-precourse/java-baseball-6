package baseball.domain;

import static baseball.enums.Constant.MAX_NUMBER_LENGTH;

import java.util.List;
import java.util.StringJoiner;

public class BaseBallGameService {

    public String startGame(ComputerRandomNumbers computerRandomNumbers, List<Integer> userInputs) {
        int strikeCount = getStrikeCount(computerRandomNumbers, userInputs);
        int ballCount = getBallCount(computerRandomNumbers, userInputs);
        String result = getResult(strikeCount, ballCount);
        return result;
    }

    private String getResult(int strikeCount, int ballCount) {
        StringJoiner stringJoiner = new StringJoiner(" ");

        if (ballCount != 0) {
            stringJoiner.add(String.format("%d볼", ballCount));
        }

        if (strikeCount != 0) {
            stringJoiner.add(String.format("%d스트라이크", strikeCount));
        }

        if (strikeCount == 0 && ballCount == 0) {
            stringJoiner.add("낫싱");
        }

        return stringJoiner.toString();
    }

    private int getStrikeCount(ComputerRandomNumbers computerRandomNumbers, List<Integer> userInputs) {
        int count = 0;
        for (int i = 0; i < MAX_NUMBER_LENGTH.getConstant(); i++) {
            if (computerRandomNumbers.get(i) == userInputs.get(i)) {
                count++;
            }
        }
        return count;
    }

    private int getBallCount(ComputerRandomNumbers computerRandomNumbers, List<Integer> userInputs) {
        int count = 0;
        for (int i = 0; i < MAX_NUMBER_LENGTH.getConstant(); i++) {
            int userNumber = userInputs.get(i);
            int computerNumberIdx = computerRandomNumbers.indexOf(userNumber);
            if (computerNumberIdx != i && computerNumberIdx != -1) {
                count++;
            }
        }
        return count;
    }

}
