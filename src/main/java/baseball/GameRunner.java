package baseball;

public class GameRunner {

    private final GameRound gameRound;

    public GameRunner(Person person, Computer computer) {
        this.gameRound = new GameRound(person, computer);
    }

    public void playGame() {
        GamePrinter.startMessage();
        while (true) {
            if (!gameRound.playRound()) {
                return;
            }
        }
    }
}
