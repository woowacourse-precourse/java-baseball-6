package baseball;

import baseball.player.Player;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.print("숫자를 입력해주세요 : ");
        String playerInputBall = Console.readLine();
        String[] inputBallSplit = playerInputBall.split("");
        List<Integer> playerBalls = new ArrayList<>();
        for (String ball:inputBallSplit) {
            playerBalls.add(Integer.valueOf(ball));
        }

        Player player = new Player(playerBalls);
    }
}
