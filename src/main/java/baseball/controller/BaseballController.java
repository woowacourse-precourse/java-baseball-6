package baseball.controller;

import baseball.domain.BallNumber;
import baseball.service.BaseballService;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class BaseballController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BaseballService baseballService;
    private final BallNumber ballNumber;

    public BaseballController(InputView inputView, OutputView outputView, BaseballService baseballService,
                              BallNumber ballNumber) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.baseballService = baseballService;
        this.ballNumber = ballNumber;
    }

    public void start() {
        // 게임 시작
        outputView.printGameStart();

        String startNewGame;

        // 사용자가 2를 입력할 때까지 게임 반복
        do {
            tryGame();
            outputView.printStartNewGameOrEndGame();
            startNewGame = inputView.inputStartNewGame();
        } while ("1".equals(startNewGame));

    }

    private void tryGame() {
        int strike = 0;

        // 랜덤한 3자리 숫자 뽑기
        List<Integer> correctNumber = ballNumber.generate();

        // 3스트라이크가 될 때까지 숫자 입력 반복
        do {
            // 3자리 숫자 입력 받기
            outputView.printInputNumbers();
            String inputNumbers = inputView.inputNumbers();

            // 숫자 비교
            List<Integer> result = baseballService.compareNumbers(correctNumber, inputNumbers);
            strike = result.get(0);

            // 결과 출력
            outputView.printGameResult(result);

        } while (strike < 3);
    }
}
