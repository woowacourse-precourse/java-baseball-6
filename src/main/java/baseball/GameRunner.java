package baseball;

public class GameRunner {

    private final GameRound gameRound;

    public GameRunner() {
        Person person = new Person();
        Computer computer = new Computer();
        GameScore gameScore = new GameScore(person, computer);
        this.gameRound = new GameRound(person, computer, gameScore);
    }

    public void playGame() {
        GameMessages.printStartMessage();
        while (true) {
            if (gameRound.playRound()) {
                return;
            }
        }
    }
}
