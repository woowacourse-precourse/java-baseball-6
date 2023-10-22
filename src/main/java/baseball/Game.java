package baseball;

public class Game {
    private Computer computer;
    private User user;
    private Hint hint;
    private boolean continueGame;

    public Game() {
        computer = new Computer();
        user = new User();
        hint = new Hint();
        continueGame = true;
    }

    public void start() {
        do {
            playGame();
        } while (continueGame);
    }

    private void playGame() {
        user.enterNumber();
        hint.calculateHint(user.userAnswer, computer.computerAnswer);
        hint.printHint();
    }

    private void toggleContinue() {
        continueGame = !continueGame;
    }
}
