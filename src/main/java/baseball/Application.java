package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameState gameState = new GameState(Output.gameStart());
        GameNumberController gameNumberController = new GameNumberController();
        GamePlayer gamePlayer = new GamePlayer(gameState, gameNumberController);
        gamePlayer.playGame();
    }
}
