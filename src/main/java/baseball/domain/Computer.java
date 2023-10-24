package baseball.domain;

import static baseball.constants.CompareConstant.BALL_COUNT;
import static baseball.constants.CompareConstant.CORRECT_ANSWER;
import static baseball.constants.CompareConstant.MAX_NUMBER_RANGE;
import static baseball.constants.CompareConstant.MIN_NUMBER_RANGE;
import static baseball.constants.CompareConstant.RESTART_NUMBER;
import static baseball.constants.CompareConstant.STRIKE_COUNT;
import static baseball.constants.CompareConstant.VALID_NUMBER_SIZE;
import static baseball.constants.SystemMessage.ANSWER_CORRECT_MESSAGE;
import static baseball.constants.SystemMessage.BALL_MESSAGE;
import static baseball.constants.SystemMessage.INIT_RESULT_MESSAGE;
import static baseball.constants.SystemMessage.NOTHING_MESSAGE;
import static baseball.constants.SystemMessage.RESTART_OR_EXIT_MESSAGE;
import static baseball.constants.SystemMessage.STRIKE_MESSAGE;
import static baseball.validation.ValidateRestartOrExitNumber.validateRestartOrExitNumber;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Computer {

    public List<Integer> createComputerNumber() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < VALID_NUMBER_SIZE) {
            int number = Randoms.pickNumberInRange(MIN_NUMBER_RANGE, MAX_NUMBER_RANGE);
            if (!computerNumber.contains(number)) {
                computerNumber.add(number);
            }
        }
        return computerNumber;
    }

    public List<Integer> compareEachNumber(List<Integer> computerNumber, List<Integer> userNumber) {
        List<Integer> resultCount = new ArrayList<>(Arrays.asList(BALL_COUNT, STRIKE_COUNT));

        countStrike(computerNumber, userNumber, resultCount);
        countBall(computerNumber, userNumber, resultCount);
        removeDuplicateBallCount(resultCount);

        return resultCount;
    }

    private void removeDuplicateBallCount(List<Integer> resultCount) {
        resultCount.set(0, resultCount.get(0) - resultCount.get(1));
    }

    private void countBall(List<Integer> computerNumber, List<Integer> userNumber, List<Integer> resultCount) {
        for (int number : userNumber) {
            if (computerNumber.contains(number)) {
                resultCount.set(0, resultCount.get(0) + 1);
            }
        }
    }

    private void countStrike(List<Integer> computerNumber, List<Integer> userNumber, List<Integer> resultCount) {
        for (int i = 0; i < 3; i++) {
            if (computerNumber.get(i).equals(userNumber.get(i))) {
                resultCount.set(1, resultCount.get(1) + 1);
            }
        }
    }

    public String createResultMessage(List<Integer> resultCount) {
        int ball = resultCount.get(0);
        int strike = resultCount.get(1);
        String resultMessage = INIT_RESULT_MESSAGE;

        resultMessage = addBallMessage(ball, resultMessage);

        resultMessage = addStrikeMessage(strike, resultMessage);

        resultMessage = addNothingMessage(ball, strike, resultMessage);

        return resultMessage;
    }

    private static String addNothingMessage(int ball, int strike, String resultMessage) {
        if (ball == 0 && strike == 0) {
            resultMessage += NOTHING_MESSAGE;
        }
        return resultMessage;
    }

    private static String addStrikeMessage(int strike, String resultMessage) {
        if (strike != 0) {
            resultMessage += strike + STRIKE_MESSAGE;
        }
        return resultMessage;
    }

    private static String addBallMessage(int ball, String resultMessage) {
        if (ball != 0) {
            resultMessage += ball + BALL_MESSAGE;
        }
        return resultMessage;
    }

    public boolean checkAnswer(String resultMessage) {
        return resultMessage.equals(CORRECT_ANSWER);
    }

    public boolean decideRestartOrExit() {
        System.out.println(ANSWER_CORRECT_MESSAGE);
        System.out.println(RESTART_OR_EXIT_MESSAGE);
        String restartOrExit = Console.readLine();
        validateRestartOrExitNumber(restartOrExit);

        return restartOrExit.equals(RESTART_NUMBER);
    }
}
