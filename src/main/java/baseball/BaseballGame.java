package baseball;

public class BaseballGame {
    private final Computer computer;
    private final UserInput userInput;
    private final Judgement judgement;
    private final OutputHandler outputHandler;

    public BaseballGame() {
        computer = new Computer();
        userInput = new UserInput();
        judgement = new Judgement();
        outputHandler = new OutputHandler();
    }

    public void start() {
        boolean shouldRestart = false;
        do {
            playGame();
        } while (shouldRestart);
    }

    private void playGame() {
    }
}
