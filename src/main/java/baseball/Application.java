package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GamePlayer gamePlayer = new GamePlayer(new GameState(Output.startGame()), new GameNumber());
        gamePlayer.playGame();
    }
}
