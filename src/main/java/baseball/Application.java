package baseball;

import baseball.game.hitter.Hitter;
import baseball.game.hitter.PlayerHitterImpl;
import baseball.game.pitcher.ComputerRandomPitcherImpl;
import baseball.game.pitcher.Pitcher;

public class Application {
    public static void main(String[] args) {

        Hitter hitter;

        AppConfig appConfig = new AppConfig();

        hitter = appConfig.hitter();

        String bat = "";

        System.out.println("입력:");
        bat = hitter.swing();
        System.out.println(bat);

        ComputerRandomPitcherImpl computerRandomPitcher = new ComputerRandomPitcherImpl();
        String ball = "";
        ball = computerRandomPitcher.pitch();
        System.out.println(ball);

    }
}
