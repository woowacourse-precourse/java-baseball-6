package baseball;

import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class Controller {

    private Validator validator;

    public Controller(Validator validator) {
        this.validator = validator;
    }

    public void run() {
        OutputView.printMessage("숫자 야구 게임을 시작합니다.");
        do {
            proceed();
        } while (isRestartGame());
    }

    private void proceed() {
        GameData gameData = initGameData();  // 게임 초기화
        proceedGame(gameData);               // 게임 진행
        endGame();                           // 게임 종료
    }

    private GameData initGameData() {
        return new GameData(new Computer());
    }

    private void proceedGame(GameData gameData) {
        while (true) {
            List<Integer> trial = validator.validateBaseballNumber(InputView.readNumber("숫자를 입력해주세요 : "));
            List<Integer> result = gameData.computer().calculateResult(trial);
            OutputView.printResult(result);
            if (isThreeStrike(result)) {
                return;
            }
        }
    }

    private boolean isThreeStrike(List<Integer> result) {
        return result.get(1) == GameOption.BASEBALL_SIZE;
    }

    private void endGame() {
        OutputView.printMessage(GameOption.BASEBALL_SIZE + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private boolean isRestartGame() {
        return validator.validatedRestart(InputView.readNumber("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")) == 1;
    }
}
