package baseball.controller;

import baseball.domain.BallNumber;
import baseball.service.BaseballService;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class BaseballController {
    private final BaseballService baseballService;
    private final InputView inputView;
    private final OutputView outputView;
    private final BallNumber ballNumber;

    public BaseballController(BaseballService baseballService, InputView inputView, OutputView outputView,
                              BallNumber ballNumber) {
        this.baseballService = baseballService;
        this.inputView = inputView;
        this.outputView = outputView;
        this.ballNumber = ballNumber;
    }

    public void start() {
        // 게임 시작
        outputView.printGameStart();
        outputView.printInputNumbers();

        // 3자리 숫자 입력 받기
        String inputNumbers = inputView.inputNumbers();

        // 랜덤한 3자리 숫자 뽑기
        List<Integer> correctNumber = ballNumber.generate();

        // 숫자 비교
        List<Integer> result = baseballService.compareNumbers(correctNumber, inputNumbers);

        // 결과 출력
        outputView.printGameResult(result);
    }
}
