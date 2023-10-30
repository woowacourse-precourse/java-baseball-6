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
            throw new IllegalArgumentException("[ERROR] 자동차 입력이 빈칸 입니다.");
        }
    }

    void validateAttempts(String attempts) throws IllegalArgumentException {
        if (attempts.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 횟수 입력이 빈칸 입니다.");
        }
        try {
            Integer.parseInt(attempts);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 횟수 입력이 숫자가 아닙니다.");
        }
    }
}
