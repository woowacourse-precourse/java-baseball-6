package baseball;

public class Application {
    public static void main(String[] args) {
        GameStatus gameStatus = new GameStatus(Output.startGame());
        GameNumber gameNumber = new GameNumber();

        GamePlayer gamePlayer = new GamePlayer(gameStatus, gameNumber);
        gamePlayer.playGame();
    }
}