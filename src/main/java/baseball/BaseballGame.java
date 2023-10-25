package baseball;

import static baseball.domain.Balls.createRandomBalls;
import static baseball.view.InputView.getEndOption;
import static baseball.view.InputView.getNumbers;
import static baseball.view.OutputView.printEnd;
import static baseball.view.OutputView.printHint;

import baseball.domain.BallNumber;
import baseball.domain.BallStatus;
import baseball.domain.Balls;
import baseball.domain.Board;
import baseball.domain.EndOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import utils.ValidationUtils;

public class BaseballGame {

    private static final int BALL_SIZE = 3;

    private Balls computer;
    private Board board;

    public void start() {
        do {
            init();
            play();
        } while (!isEnd());
    }

    private void init() {
        computer = createRandomBalls();
        board = new Board();
    }

    private void play() {
        do {
            board.reset();
            process(computer);
        } while (!board.isMatch(BALL_SIZE));
        printEnd();
    }

    private boolean isEnd() {
        int option = getOptionNumber();
        return option == EndOption.END.getValue();
    }

    private void process(Balls computer) {
        List<BallNumber> ballNumbers = getBallNumbers();
        for (int i = 0; i < BALL_SIZE; i++) {
            BallStatus result = computer.compare(ballNumbers.get(i), i);
            board.scoring(result);
        }
        printHint(board);
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

