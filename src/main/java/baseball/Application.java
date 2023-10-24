package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        PlayGame playGame = new PlayGame(
                new InputView(),
                new OutputView(),
                new Judge()
        );
        playGame.startGame();
    }
}
