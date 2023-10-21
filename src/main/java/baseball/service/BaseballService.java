package baseball.service;

import static baseball.validation.Validation.inputValidate;
import static baseball.validation.Validation.restartValidate;
import baseball.domain.Score;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class BaseballService {

    Score score = new Score();

    public String compareNumber(List<Integer> computerNumber, List<Integer> playerNumber) {
        int strike = score.countStrike(computerNumber, playerNumber);
        int ball = score.countBall(computerNumber, playerNumber);

        if (strike == 0 && ball == 0) {
            return "낫싱";
        }
        if (strike == 0) {
            return ball + "볼";
        }
        if (ball == 0) {
            return strike + "스트라이크";
        }
        return ball + "볼 " + strike + "스트라이크";
    }
    public List<Integer> InputPlayerNumber() {
        String input = Console.readLine();
        inputValidate(input);

        return changeStringToList(input);
    }

    public List<Integer> changeStringToList(String userNumber) {
        List<Integer> playerNumber = new ArrayList<>();

        for (String userNumbers : userNumber.split("")) {
            playerNumber.add(Integer.parseInt(userNumbers));
        }

        return playerNumber;
    }

    public String InputPlayerRestartNumber() {
        String input = Console.readLine();
        restartValidate(input);

        return input;
    }
}
