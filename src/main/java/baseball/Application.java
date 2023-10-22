package baseball;

import baseball.randomNumber.RandomNumber;
import baseball.game.Game;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        Game.printStartMessage();

        while (true) {
            List<Integer> computerNumber = RandomNumber.createRandomNumber();
            Game.doGame(computerNumber);
            if (!Game.newGame()) {
                break;
            }
        }
    }
}
