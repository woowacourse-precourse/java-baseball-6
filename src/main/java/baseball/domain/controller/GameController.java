package baseball.domain.controller;

import baseball.domain.dto.ResultDto;
import baseball.domain.dto.UserInputDto;
import baseball.domain.model.Computer;
import baseball.utils.InputValidator;
import baseball.domain.model.Score;
import baseball.domain.model.User;

import java.util.List;

import static baseball.domain.controller.Game.RESTART_SIGNAL;

public class GameController {
    private final Computer computer;

    public GameController(List<String> computerBalls) {
        this.computer = new Computer(computerBalls);
    }

    public ResultDto doGame(UserInputDto userInputDto) {
        User user = new User(userInputDto.getUserInput());
        Score score = new Score(this.computer, user);

        return new ResultDto(score);
    }

    public Boolean restartGame(UserInputDto userInputDto) {
        InputValidator.checkRestartInput(userInputDto.getUserInput());

        return RESTART_SIGNAL.equals(userInputDto.getUserInput());
    }
}
