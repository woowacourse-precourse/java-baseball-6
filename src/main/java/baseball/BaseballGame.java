package baseball;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private final Computer computer;
    private final User user;
    private final Logic logic;
    private final GameResult gameResult;

    public BaseballGame() {
        this.computer = new Computer();
        this.user = new User();
        this.logic = new Logic();
        this.gameResult = new GameResult();
    }

    public void play() {
        while (true) {
            List<Integer> userNumbers = parseUserInput();
            int strikes = logic.countStrikes(computer.getNumbers(), userNumbers);
            int balls = logic.countBalls(computer.getNumbers(), userNumbers);
            gameResult.printResult(strikes, balls);

            if (strikes == 3) {
                break;
            }
        }
    }

    private List<Integer> parseUserInput() {
        while (true) {
            String input = user.input();
            if (isValid(input)) {
                return toIntegerList(input);
            }
            throw new IllegalArgumentException("유효하지 않은 입력입니다.");
        }
    }

    private boolean isValid(String input) {
        if (input.length() != 3) {
            return false;
        }

        List<Integer> numbers = toIntegerList(input);
        if (numbers.size() != 3) {
            return false;
        }

        for (int num : numbers) {
            if (num < 1 || num > 9) {
                return false;
            }
        }

        return true;
    }

    private List<Integer> toIntegerList(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (char ch : input.toCharArray()) {
            numbers.add(ch - '0');
        }
        return numbers;
    }
}
