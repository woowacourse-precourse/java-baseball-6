package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String inputCarNames() {
        String carNames = Console.readLine();
        validateCarNames(carNames);
        return carNames;
    }

    public int inputAttempts() {
        String attempts = Console.readLine();
        validateAttempts(attempts);
        return Integer.parseInt(attempts);
    }

    void validateCarNames(String inputCarNames) throws IllegalArgumentException {
        if (inputCarNames.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    void validateAttempts(String attempts) throws IllegalArgumentException {
        if (attempts.isEmpty()) {
            throw new IllegalArgumentException();
        }
        try {
            Integer.parseInt(attempts);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
