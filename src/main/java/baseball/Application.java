package baseball;

import baseball.game.hitter.PlayerHitterImpl;
import baseball.game.pitcher.ComputerRandomPitcherImpl;

public class Application {
    public static void main(String[] args) {
//        PlayerHitterImpl hitter = new PlayerHitterImpl();
//
//        String bat = "";
//
//        System.out.println("입력:");
//        bat = hitter.swing();

        ComputerRandomPitcherImpl computerRandomPitcher = new ComputerRandomPitcherImpl();
        String ball = "";
        ball = computerRandomPitcher.pitch();
        System.out.println(ball);

    }
}
