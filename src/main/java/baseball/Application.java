package baseball;

public class Application {
    public static void main(String[] args) {
        GamePlayer gamePlayer = new GamePlayer(new GameState(Output.startGame()), new GameNumber());
        gamePlayer.playGame();
    }
}
