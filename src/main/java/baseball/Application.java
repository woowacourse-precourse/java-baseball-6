package baseball;

import baseball.domain.GameManger;

public class Application {
    public static void main(String[] args) {
        GameManger gameManger = new GameManger();
        gameManger.startGame();
    }
}
