package baseball.domain;

import static baseball.console.Constant.INT_ZERO;
import static baseball.console.Constant.RESULT_BALL;
import static baseball.console.Constant.RESULT_NOTHING;
import static baseball.console.Constant.RESULT_STRIKE;
import static baseball.domain.BaseballNumber.NUMBER_MAX_VALUE;
import static baseball.domain.BaseballNumber.NUMBER_MIN_VALUE;

import baseball.console.Constant;
import baseball.console.Input;
import baseball.console.Output;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballGame {

    private BaseballNumbers computerNumbers;
    private BaseballNumbers userNumbers;

    public void playGame() {
        computerNumbers = generateComputerNumbers();
        do {
            tryGame();
        } while (!isCorrect());

        Output.printBaseballGameTermination();
    }

    private void tryGame() {
        userNumbers = receiveUserNumbers();
        Output.printBaseballGameHint(printResult());
    }

    private BaseballNumbers generateComputerNumbers() {
        List<BaseballNumber> computerNumbers = new ArrayList<>();
        Set<Integer> isDuplicateSet = new HashSet<>();

        while (computerNumbers.size() < BaseballNumbers.NUMBERS_MAX_SIXE) {
            int randomNumber = Randoms.pickNumberInRange(NUMBER_MIN_VALUE, NUMBER_MAX_VALUE);

            isDuplicateSet.add(randomNumber);
            if (computerNumbers.size() + 1 != isDuplicateSet.size()) {
                continue;
            }

            computerNumbers.add(new BaseballNumber(randomNumber));
        }
        return new BaseballNumbers(computerNumbers);
    }

    private BaseballNumbers receiveUserNumbers() {

        String numberStr = Input.receiveBaseballNumber();
        List<BaseballNumber> userNumbers = new ArrayList<>();

        while (userNumbers.size() < numberStr.length()) {
            userNumbers.add(new BaseballNumber(numberStr.charAt(userNumbers.size()) - Constant.CHAR_ZERO));
        }
        return new BaseballNumbers(userNumbers);
    }

    private boolean isCorrect() {
        return computerNumbers.equals(userNumbers);
    }

    private String printResult() {

        StringBuilder stringBuilder = new StringBuilder();

        int strikeCount = computerNumbers.getStrikeCount(userNumbers);
        int ballCount = computerNumbers.getBallCount(userNumbers);

        if (strikeCount == INT_ZERO && ballCount == INT_ZERO) {
            stringBuilder.append(RESULT_NOTHING);
        } else if (strikeCount != INT_ZERO && ballCount != INT_ZERO) {
            stringBuilder.append(ballCount).append(RESULT_BALL).append(" ")
                    .append(strikeCount).append(RESULT_STRIKE);
        } else if (strikeCount != INT_ZERO) {
            stringBuilder.append(strikeCount).append(RESULT_STRIKE);
        } else if (ballCount != INT_ZERO) {
            stringBuilder.append(ballCount).append(RESULT_BALL);
        }
        return stringBuilder.toString();
    }
}
