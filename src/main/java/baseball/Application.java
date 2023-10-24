package baseball;

import baseball.game.Game;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            Game game = new Game();
            game.start();
            if (game.end()) {
                break;
            }
        }
        Console.close();
    }
}