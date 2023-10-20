package baseball.service;

import baseball.domain.Computer;
import baseball.domain.User;
import java.util.List;

/**
 * 4. playBaseballGame() : 야구 게임 로직 (볼, 스트라이크, 낫싱)
 */
public class Play {
    public void playBaseBallGame(Computer computer, User user) {
        int strike = 0;
        int ball = 0;
        List<Integer> computerValue = computer.getComputerValue();
        for (int i = 0; i < computerValue.size(); i++) {
            if (user.getUserValue().contains(computerValue.get(i))) {
                if (user.getUserValue().indexOf(computerValue.get(i)) == i) {
                    strike++;
                } else {
                    ball++;
                }
            }
        }
        user.setStrike(strike);
        user.setBall(ball);
    }
}
