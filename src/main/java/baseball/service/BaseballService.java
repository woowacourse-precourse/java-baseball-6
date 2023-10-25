package baseball.service;

import baseball.domain.Command;
import baseball.domain.Computer;
import baseball.domain.Judgment;
import baseball.domain.Player;
import baseball.domain.Result;
import baseball.dto.ResultDto;
import baseball.utils.NumberGenerator;
import baseball.utils.RandomNumberGenerator;

public class BaseballService {
    private Computer computer;
    private final Judgment judgment;
    private final NumberGenerator numberGenerator;

    public BaseballService() {
        this.numberGenerator = new RandomNumberGenerator();
        this.judgment = new Judgment();
    }

    public void init() {
        computer = new Computer(numberGenerator);
    }

    public void playGame(String number) {
        Player player = new Player(number);
        judgment.judge(computer, player);
    }

    public ResultDto getGameResult() {
        Result result = Result.of(judgment);
        return new ResultDto(judgment.getBall(), judgment.getStrike(), result.getMessageFormat());
    }

    public Boolean isGameOver() {
        return judgment.isAllStrike();
    }

    public Boolean isRetry(String input) {
        Command command = Command.of(input);
        return command.isRetry();
    }
}
