package baseball.service;

import static baseball.util.MessageFormatter.CURRENT_GAME_CLOSE;
import static baseball.util.MessageFormatter.NOTHING_MESSAGE;
import static baseball.util.MessageFormatter.QUIT;
import static baseball.util.MessageFormatter.THREE_STRIKE;
import static baseball.util.MessageFormatter.USER_START;

import baseball.domain.Computer;
import baseball.domain.User;
import baseball.util.MessageFormatter;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class BaseballService {

    public void startGame(Computer computer) {
        while (true) {
            System.out.print(USER_START);
            String inputStatus = Console.readLine();
            if (inputStatus.equalsIgnoreCase(QUIT) || handleUserInput(computer, inputStatus)) {
                handleGameExit();
                break;
            }
        }
    }

    private boolean handleUserInput(Computer computer, String inputStatus) {
        User user = new User(inputStatus);
        int[] result = playBall(computer, user);
        if (result[0] == 3) {
            printThreeStrike(result[0]);
            return true;
        }
        printOtherResult(result);
        return false;
    }

    private int[] playBall(Computer computer, User user) {
        int[] count = new int[2];
        String userData = user.getData();
        List<Integer> comData = computer.getRandomNumber();
        for (int i = 0; i < comData.size(); i++) {
            int numericValue = Character.getNumericValue(userData.charAt(i));
            if (isStrike(comData, i, numericValue)) {
                count[0]++;
            } else if (isBall(comData, numericValue)) {
                count[1]++;
            }
        }
        return count;
    }

    private boolean isStrike(List<Integer> comData, int index, int numericValue) {
        return comData.get(index) == numericValue;
    }

    private boolean isBall(List<Integer> comData, int numericValue) {
        return comData.contains(numericValue);
    }

    private void printOtherResult(final int[] result) {
        int strike = result[0];
        int ball = result[1];

        if (strike != 0 && ball != 0) {
            handleBallStrike(ball, strike);
        } else if (strike != 0) {
            handleStrike(strike);
        } else if (ball != 0) {
            handleBall(ball);
        } else {
            handelNothing();
        }
    }

    private void handleGameExit() {
        System.out.println(CURRENT_GAME_CLOSE);
    }

    private void printThreeStrike(int strike) {
        System.out.println(MessageFormatter.formatStrikeMessage(strike));
        System.out.println(THREE_STRIKE);

    }

    private void handelNothing() {
        System.out.println(NOTHING_MESSAGE);
    }

    private void handleBallStrike(int ball, int strike) {
        System.out.println(MessageFormatter.formatBallStrikeMessage(ball, strike));
    }

    private void handleStrike(int strike) {
        System.out.println(MessageFormatter.formatStrikeMessage(strike));
    }

    private void handleBall(int ball) {
        System.out.println(MessageFormatter.formatBallMessage(ball));
    }
}
