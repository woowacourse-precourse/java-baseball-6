package baseball;

import static baseball.view.InputView.getNumbers;

import baseball.domain.BallStatus;
import baseball.domain.Balls;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import utils.ValidationUtils;

public class BaseballGame {

    private static final int BOARD_SIZE = 3;
    private static final int BALL_SIZE = 3;

    private int[] board;

    public void start() {
        Balls computer = createComputerBalls();
        initBoard();
        play(computer);
    }

    private Balls createComputerBalls() {
        return new Balls(createComputer());
    }

    private void initBoard() {
        board = new int[BOARD_SIZE];
    }

    private void play(Balls computer) {
        List<Integer> balls = getBallNumbers();
        for (int i = 0; i < BALL_SIZE; i++) {
            int result = computer.compare(balls.get(i), i);
            board[result]++;
        }
    }

    private List<Integer> createComputer() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    private List<Integer> getBallNumbers() {
        String inputNumbers = getNumbers();
        validateInput(inputNumbers);
        List<Integer> numbers = parseNumbers(inputNumbers);
        validateNumbers(numbers);
        return numbers;
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
        return numbers;
    }

    private void validateNumbers(List<Integer> numbers) {
        for (Integer number : numbers) {
            validateNumber(number);
        }
        if (!ValidationUtils.isOtherNumbers(numbers)) {
            throw new IllegalArgumentException("잘못된 입력입니다. 서로 다른 숫자를 입력해 주세요.");
        }
    }

    private static void validateNumber(Integer number) {
        if (!ValidationUtils.isSingleNumber(number)) {
            throw new IllegalArgumentException("잘못된 입력입니다. 1-9 사이의 숫자를 입력해 주세요.");
        }
    }
}

