package baseball;

import static baseball.view.InputView.getEndOption;
import static baseball.view.InputView.getNumbers;
import static baseball.view.OutputView.printEnd;
import static baseball.view.OutputView.printHint;

import baseball.domain.BallNumber;
import baseball.domain.Board;
import baseball.domain.Game;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import utils.ValidationUtils;

public class BaseballGame {

    private final Game game;

    public BaseballGame() {
        game = new Game();
    }

    public void start() {
        do {
            game.init();
            run();
        } while (!game.isEnd(getOptionNumber()));
    }

    private void run() {
        do {
            Board board = game.process(getBallNumbers());
            printHint(board);
        } while (!game.isMatch());
        printEnd();
    }

    private List<BallNumber> getBallNumbers() {
        String inputNumbers = getNumbers();
        validateInput(inputNumbers);
        List<Integer> numbers = parseNumbers(inputNumbers);
        return numbers.stream()
            .map(BallNumber::new)
            .collect(Collectors.toList());
    }
    private void validateInput(String inputNumbers) {
        if (!ValidationUtils.isNumber(inputNumbers)) {
            throw new IllegalArgumentException("잘못된 입력입니다. 숫자를 입력해 주세요.");
        }
    }

    private List<Integer> parseNumbers(String inputNumbers) {
        List<Integer> numbers = new ArrayList<>();
        for (char c : inputNumbers.toCharArray()) {
            numbers.add(c - '0');
        }
        if (numbers.size() != 3) {
            throw new IllegalArgumentException("잘못된 입력입니다. 3자리의 숫자를 입력해 주세요.");
        }
        return numbers;
    }

    private int getOptionNumber() {
        String option = getEndOption();
        validateInput(option);
        int number = Integer.parseInt(option);
        validateOption(number);
        return number;
    }

    private void validateOption(int number) {
        if (!ValidationUtils.isEndOptionNumber(number)) {
            throw new IllegalArgumentException("잘못된 입력입니다. 1(재시작) 또는 2(종료)를 입력해주세요.");
        }
    }
}

