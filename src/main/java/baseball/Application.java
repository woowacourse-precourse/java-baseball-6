package baseball;

import java.io.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean finished = false;
        while (!finished) {
            Game game  = new Game(3);
            game.run();
            String input = Utils.printAndInput(PrintMessage.RE_GAME);
            finished = game.selectRestartOrExit(input);
        }
    }
}
