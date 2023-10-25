package baseball.contoller;

import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.domain.Referee;
import baseball.service.BaseballService;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

public class BaseballController {

    private final BaseballService baseballService;

    public BaseballController() {
        this.baseballService = new BaseballService();
    }

    private boolean restart;

    public void startGame() {
        OutputView.printGameStartMessage();
        do {
            restart = true;
            Computer computer = new Computer();
            Player player = new Player();

            callNumberToMatch(computer, player);
        } while (restart);
        Console.close();
    }

    void callNumberToMatch(Computer computer, Player player) {
        do {
            String number = InputView.inputNumbers();
            baseballService.verifyException(number);
            player.callNumber(number);

            Referee referee = new Referee(computer, player);
            referee.checkResult();

            OutputView.printResultMessage(referee.getStrike(), referee.getBall());

            if (referee.getStrike() == 3) {
                OutputView.printMatchAllNumberMessage();
                restart = baseballService.restart(InputView.inputRestart());
                return;
            }
        } while (restart);
    }
}
