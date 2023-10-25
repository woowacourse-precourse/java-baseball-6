package baseball.domain;

import baseball.service.ComputerService;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final List<Integer> answer = new ArrayList<>();
    private static final int RANDOM_NUMBERS = 3;

    public void setAnswer() {
        while (answer.size() < RANDOM_NUMBERS) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
    }

    public String getResult(List<Integer> playerInput) {
        int ball = ComputerService.countBall(playerInput, answer);
        int strike = ComputerService.countStrike(playerInput, answer);
        return ComputerService.getResultMessage(ball, strike);
    }
}
