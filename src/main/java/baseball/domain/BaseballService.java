package baseball.domain;

import baseball.dto.BaseballResultDto;
import baseball.utils.NumberGenerator;
import baseball.utils.RandomNumberGenerator;

public class BaseballService {
    private Computer computer;
    private final BaseballGame baseballGame;
    private final NumberGenerator numberGenerator = new RandomNumberGenerator();

    public BaseballService() {
        this.baseballGame = new BaseballGame();
    }

    public void init() {
        this.computer = new Computer(numberGenerator);
    }

    public void playGame(String number) {
        Player player = new Player(number);
        baseballGame.compare(computer, player);
    }

    public BaseballResultDto getGameResult() {
        return baseballGame.getGameResult();
    }

    public Boolean isGameOver() {
        return baseballGame.isGameOver();
    }

    public Boolean isRetry(String input) {
        Command command = Command.of(input);
        return command.isRetry();
    }
}
