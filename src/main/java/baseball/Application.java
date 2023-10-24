package baseball;

import baseball.services.Game;

public class Application {
    public static void main(String[] args) {
        while (Game.createGame()) {
        }
    }
}
