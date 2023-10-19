package baseball.service;

import static baseball.util.Message.CURRENT_GAME_CLOSE;
import static baseball.util.Message.NOTHING_MESSAGE;
import static baseball.util.Message.QUIT;
import static baseball.util.Message.THREE_STRIKE;
import static baseball.util.Message.USER_START;

import baseball.domain.Computer;
import baseball.domain.User;
import baseball.util.Message;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class BaseballService {

    public void getStart(Computer computer) {

        while (true) {
            System.out.print(USER_START);
            String status = Console.readLine();
            if (status.equalsIgnoreCase(QUIT)) {
                System.out.println(CURRENT_GAME_CLOSE);
                break;
            }
            User user = new User(status);

            int[] result = playBall(computer, user);
            if (result[0] == 3) {
                System.out.println(Message.formatStrikeMessage(result[0]));
                System.out.println(THREE_STRIKE);
                break;
            }
            printResult(result);
        }
    }

    private int[] playBall(Computer computer, User user) {
        int[] count = new int[2];
        String userData = user.getData();
        List<Integer> comData = computer.getRandomNumber();
        for (int i = 0; i < comData.size(); i++) {
            int numericValue = Character.getNumericValue(userData.charAt(i));
            if (comData.get(i) == numericValue) {
                count[0]++;
            }
            if (comData.get(i) != numericValue && comData.contains(numericValue)) {
                count[1]++;
            }
        }
        return count;
    }

    private void printResult(final int[] result) {
        int strike = result[0];
        int ball = result[1];

        if (strike != 0 && ball != 0) {
            System.out.println(Message.formatBallStrikeMessage(ball, strike));
        }

        if (strike != 0 && ball == 0) {
            System.out.println(Message.formatStrikeMessage(strike));
        }

        if (strike == 0 && ball != 0) {
            System.out.println(Message.formatBallMessage(ball));
        }
        if (strike == 0 && ball == 0) {
            System.out.println(NOTHING_MESSAGE);
        }
    }
}
