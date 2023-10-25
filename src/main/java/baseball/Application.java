package baseball;

import static baseball.status.GameMsg.GAME_START;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        System.out.println(GAME_START.getMsg());
        Game game = new Game();
        game.play();
        Console.close();
    }
}
