package baseball.Interface;

import baseball.game.BaseballGame;
import java.io.Console;

public class UserInterface {
    private final Console console;
    private final BaseballGame baseballGame;

    public UserInterface(Console console, BaseballGame baseballGame) {
        this.console = console;
        this.baseballGame = baseballGame;
    }

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            startGame();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String input = console.readLine();
            if (input.equals("2")) {
                break;
            }
            if (!input.equals("1")) {
                throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
            }
        }
    }

}
