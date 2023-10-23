package baseball.controller;

import static baseball.constant.Message.GAME_START;
import static baseball.constant.Message.INSERT_END_INPUT;
import static baseball.constant.Message.INSERT_GAME_INPUT;

import baseball.service.IOService;
import baseball.dto.NumbersScoreDto;
import baseball.model.Computer;
import baseball.model.EndInput;
import baseball.model.GameInput;
import baseball.model.Numbers;
import baseball.model.Score;

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
            playGameUntilUserWin(computer, score);
        } while (getEndInput().isPressResume());
    }

    private void playGameUntilUserWin(Computer computer, Score score) {
        while (score.isUserLose()) {
            GameInput gameInput = new GameInput(ioService.readInput(INSERT_GAME_INPUT));
            Numbers userNumbers = new Numbers(gameInput.convertInputToUserNumbers());
            NumbersScoreDto numbersScoreDto = computer.calculateScoreWithUserNumbers(userNumbers);
            score = numbersScoreDto.toModel();
            ioService.println(score.getHint());
        }
    }

    private EndInput getEndInput() {
        return new EndInput(ioService.readInput(INSERT_END_INPUT));
    }
}
