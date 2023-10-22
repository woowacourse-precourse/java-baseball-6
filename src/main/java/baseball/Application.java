package baseball;

import baseball.service.Game;

import static baseball.constants.Constants.GAME_START_STRING;

public class Application {


    public static void main(String[] args) {
        System.out.println(GAME_START_STRING);

        Game game = new Game();
        do {
            game.play();
        } while (game.isReplay());
    }
}
