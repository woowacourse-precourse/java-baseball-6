package baseball.Controller;

import baseball.Game.Play;
import baseball.Game.Restart;

public class GameController {
    public static void Start() {

        System.out.println("숫자 야구 게임을 시작합니다.");

        String restart = "1";

        while (restart.equals("1")) {

            Play.play();

            restart = Restart.restart();
        }
    }

}
