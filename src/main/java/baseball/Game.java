package baseball;

public class Game {
    public void startGame() {
        Output.startCommand();
        do {
            BaseballGame baseballGame = new BaseballGame();
            baseballGame.play();
        } while (Input.isNewGame());
    }
}
