package baseball;

public class GameRunner {

    private final GameRound gameRound;

    public GameRunner() {
        Person person = new Person();
        Computer computer = new Computer();
        this.gameRound = new GameRound(person, computer);
    }

    public void playGame() {
        GameMessages.printStartMessage();
        while (true) {
            if (!gameRound.playRound()) {
                return;
            }
        }
    }
}
