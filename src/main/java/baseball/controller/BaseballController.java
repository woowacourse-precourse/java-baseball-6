package baseball.controller;

import baseball.domain.BallNumber;
import baseball.service.BaseballService;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

        String inputStartNewGame;

        // 사용자가 2를 입력할 때까지 게임 반복
        do {
            tryGame();
            inputStartNewGame = inputView.inputStartNewGame();
            validateInputStartNewGame(inputStartNewGame);
        } while ("1".equals(inputStartNewGame));

    }

    private void tryGame() {
        int strike = 0;

        // 랜덤한 3자리 숫자 뽑기
        List<Integer> correctNumber = ballNumber.generate();

        // 3스트라이크가 될 때까지 숫자 입력 반복
        do {
            // 3자리 숫자 입력 받기
            String inputNumbers = inputView.inputNumbers();
            validateNumberDuplication(inputNumbers);

            // 숫자 비교
            List<Integer> result = baseballService.compareNumbers(correctNumber, inputNumbers);
            strike = result.get(0);

            // 결과 출력
            outputView.printGameResult(result);

        } while (strike < 3);
    }

    private void validateInputStartNewGame(final String inputStartNewGame) {
        if (!"1".equals(inputStartNewGame) && !"2".equals(inputStartNewGame)) {
            throw new IllegalArgumentException("게임 재시작 여부는 숫자 1, 2만 입력 가능합니다.");
        }
    }

    private void validateNumberDuplication(final String inputNumbers) {

        List<String> inputList = Arrays.stream(inputNumbers.split("")).toList();

        Set<String> inputSet = new HashSet<>(inputList);

        if (inputSet.size() != 3) {
            throw new IllegalArgumentException("중복되지 않는 3자리 숫자만 입력가능합니다.");
        }
    }
}
