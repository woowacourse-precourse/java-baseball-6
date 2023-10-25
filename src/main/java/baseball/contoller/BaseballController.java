package baseball.contoller;

//Controller
//    - 게임을 최초 시작한다.
//      - 게임을 시작하면 플레이어와 컴퓨터를 생성한다.
//      - 숫자를 부르는 메서드로 이동한다.
//    - 숫자를 제시한다.
//      - 서로 다른 3개의 숫자를 입력한다.
//          - 예외 1) 3자리가 아니면 IllegalArgumentException 을 발생시킨다.
//          - 예외 2) 하나라도 숫자가 아니면 IllegalArgumentException 을 발생시킨다.
//      - 3개의 숫자를 모두 맞히면 게임이 종료된다.
//    - 게임이 종료되면 게임을 다시 시작하거나(1) 완전히 종료시킨다(2).

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
