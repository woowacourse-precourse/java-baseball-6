package racingcar.ui;
import static racingcar.ui.OutputView.printInputAttemptMessage;
import static racingcar.ui.OutputView.printInputCarNamesMessage;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.exception.InvalidInputException;

public class InputView {
    private static final String CAR_NAME_REGEX = "^[A-Za-z0-9,]*[A-Za-z0-9]$";
    public static List<String> inputCarNames() throws InvalidInputException {
        printInputCarNamesMessage();
        String input = Console.readLine();
        validateCarNames(input);
        return List.of(input.split(","));
    }

    private static void validateCarNames(String input) throws InvalidInputException {
        if(!input.matches(CAR_NAME_REGEX)) {
            throw new InvalidInputException("[ERROR] 이름 입력의 형식이 잘못됐습니다.", input);
        }
    }

    public static int inputAttempt() throws InvalidInputException {
        printInputAttemptMessage();
        String input = Console.readLine();
        validateAttempt(input);
        return Integer.parseInt(input);
    }

    private static void validateAttempt(String input) throws InvalidInputException{
        int attempt;
        try {
            attempt = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidInputException("[ERROR] 숫자를 입력해주세요", input);
        }

        if (attempt < 1) {
            throw new InvalidInputException("[ERROR] 1 이상의 숫자를 입력해주세요", input);
        }
    }
}
