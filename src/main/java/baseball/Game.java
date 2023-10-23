package baseball;

import static baseball.Constants.*;

public class Game {
    private Computer computer;
    private User user;
    private Result result;

    public Game() {
        System.out.println(GAME_START_MESSAGE);
        start();
    }

    public void start() {
        setGame();
        playGame();
        askRetry();
    }

    private void setGame() {
        computer = new Computer();
        computer.getNumbers().stream().forEach(System.out::println);
        user = new User();
        result = new Result();
    }

    private void playGame() {
        while (!result.isThreeStrike()) {
            user.inputNumbers();
            result.checkResult(user.getNumbers(), computer.getNumbers());
            result.printResult();
        }
        System.out.println(FINISH_GAME_MESSAGE);
    }

    private void askRetry() {
        GameCommand gameCommand = user.inputGameCommand();
        if(gameCommand.isRetry()){
            start();
        }
    }
}
