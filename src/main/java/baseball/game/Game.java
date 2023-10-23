package baseball.game;

import baseball.player.Computer;
import baseball.player.User;
import java.util.List;
import java.util.Objects;

public class Game {

    public Game(Computer computer, User user) {
        List<Integer> computerNumber = computer.getNumber();
        List<Integer> userNumber = user.getNumber();
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < 3; i++) {
            if (Objects.equals(computerNumber.get(i), userNumber.get(i))) {
                strikes++;
            } else if (computerNumber.contains(userNumber.get(i))) {
                balls++;
            }
        }

        user.setStrikes(strikes);
        user.setBalls(balls);
    }
}
