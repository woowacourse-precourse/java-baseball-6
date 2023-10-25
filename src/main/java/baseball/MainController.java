package baseball;

import baseball.model.Computer;
import baseball.model.GameData;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class MainController {

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
        return new GameData(new Computer(Utils.createUniqueNumberList(
                GameOption.BASEBALL_SIZE,
                GameOption.BASEBALL_START_NUMBER,
                GameOption.BASEBALL_END_NUMBER)));
    }

    private void proceedGame(GameData gameData) {
        while (true) {
            List<Integer> trial = Utils.splitNumberToDigitList(InputView.inputNumber("숫자를 입력해주세요 : "));
            Validator.validatedBaseballNumber(trial);
            List<Integer> trialResult = gameData.computer().calculateResult(trial);
            OutputView.printResult(trialResult);
            if (isThreeStrike(trialResult)) {
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
        int inputValue = InputView.inputNumber("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Validator.validatedRestart(inputValue);
        return inputValue == 1;
    }
}
