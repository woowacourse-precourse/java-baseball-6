package baseball.controller;

import baseball.domain.BaseballService;
import baseball.dto.BaseballResultDto;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballController {

    public void run() {
        OutputView.printStart();
        BaseballService service = new BaseballService();

        do {
            service.init();

            do {
                playGame(service);
                printGameResult(service);
            } while (!service.isGameOver());

        } while (isRetry(service));

    }

    private Boolean isRetry(BaseballService service) {
        OutputView.printGameOver();
        String command = InputView.inputRetryOrQuit();
        return service.isRetry(command);
    }

    private void playGame(BaseballService service) {
        String number = InputView.inputNumber();
        service.playGame(number);
    }

    private void printGameResult(BaseballService service) {
        BaseballResultDto gameResult = service.getGameResult();
        OutputView.printBaseballResult(gameResult);
    }
}
