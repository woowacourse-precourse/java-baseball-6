package baseball.controller;

import baseball.enums.RestartEnum;
import baseball.model.HintModel;
import baseball.model.NumberModel;
import baseball.util.RandomNumber;
import baseball.util.ToNumberModel;
import baseball.util.Verifier;
import baseball.view.InputView;
import baseball.view.OutputView;

/**
 * 야구 게임 컨트롤러
 */
public class BaseBall {
    private RestartEnum restart = RestartEnum.END;

    /**
     * 게임 실행
     */
    public void start() {
        NumberModel userNumber;
        NumberModel computerNumber;

        if (!restart.isRestart()) {
            OutputView.printGameStart();
        }

        computerNumber = RandomNumber.generate();
        HintModel hintModel;

        do {
            String userInput = InputView.getUserInput();
            userNumber = ToNumberModel.userInputToNumberModel(userInput);
            hintModel = computerNumber.compare(userNumber);
            OutputView.printHint(hintModel);
        } while (!hintModel.isAllStrikes());

        OutputView.printGameEnd();
        restart();
    }

    /**
     * 게임 재시작 여부 확인
     */
    public void restart() {
        String restartInput = InputView.getRestartInput();
        Verifier.verifyRestartInput(restartInput);
        restart = RestartEnum.of(restartInput);
        if (restart.isRestart()) {
            start();
        }
    }
}
