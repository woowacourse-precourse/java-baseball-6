package baseball;

import static baseball.GameStatus.IN_PROGRESS;

public class Game {
    private final Computer computer;
    private final User user;
    private final GameScreen gameScreen;
    private GameStatus gameStatus;

    public Game() {
        this.computer = new Computer();
        this.user = new User();
        this.gameScreen = new GameScreen();
        this.gameStatus = IN_PROGRESS;
    }

    public void play() {
        gameScreen.printStartMessage();
        execute();
    }

    private void execute() {
        setGame();
        do {
            gameScreen.printInputNumberMessage();
            getResult(gameScreen.receiveInputNumber());
        } while (gameStatus.equals(IN_PROGRESS));
    }

    private void setGame() {
        computer.createBaseballs();
        gameStatus = IN_PROGRESS;
    }

    public void getResult(String input) {
        user.createBaseballs(input);
        Result result = new Result(user.getBaseballs(), computer.getBaseballs());
        gameScreen.printResult(result.getResult());

        if (result.isClear()) {
            retryOrEnd();
        }
    }

    private void retryOrEnd() {
        gameScreen.printGameFinishMessage();
        gameScreen.printGameOption();
        try {
            gameStatus = GameStatus.of(Integer.parseInt(gameScreen.receiveInputGameOption()));
            if (gameStatus.equals(IN_PROGRESS)) execute();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 옵션입니다.");
        }
    }

}
