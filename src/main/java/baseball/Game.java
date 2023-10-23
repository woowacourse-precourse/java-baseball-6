package baseball;

import static baseball.Message.GAME_START;
import static baseball.Message.INSERT_END_INPUT;
import static baseball.Message.INSERT_GAME_INPUT;

public class Game {
    private final IOService ioService;

    public Game() {
        this.ioService = new IOService();
    }

    public void run() {
        ioService.println(GAME_START);
        do {
            Computer computer = new Computer();
            Score score = new Score();
            while (score.isUserLose()) {
                GameInput gameInput = new GameInput(ioService.readInput(INSERT_GAME_INPUT));
                Numbers userNumbers = new Numbers(gameInput.convertInputToUserNumbers());
                score = computer.calculateScore(userNumbers);
                ioService.println(score.getHint());
            }
        } while (new EndInput(ioService.readInput(INSERT_END_INPUT)).isPressResume());
    }

}
