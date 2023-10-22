package baseball;

import baseball.service.Game;
import camp.nextstep.edu.missionutils.Console;

import static baseball.constants.Constants.GAME_START_STRING;

public class Application {


    public static void main(String[] args) {
        Game game = new Game();
        playGame(game);
    }

    private static void playGame(Game game) {
        System.out.println(GAME_START_STRING);

        do {
            game.play();
        } while (game.isReplay(Console.readLine()));
    }
}
