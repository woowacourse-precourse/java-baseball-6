package baseball.view;

import java.util.List;

import baseball.dto.request.PlayerNumberDto;
import baseball.util.InputConverter;
import baseball.util.InputValidator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_PLAYER_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";

    private static final String PLAYER_NUMBER_DELIMITER = "";

    private InputView() {
    }

    public static InputView getInstance() {
        return LazyHolder.INSTANCE;
    }

    public PlayerNumberDto scanPlayerNumbers() {
        System.out.print(INPUT_PLAYER_NUMBER_MESSAGE);
        String rawPlayerNumbers = Console.readLine();
        validatePlayerNumbers(rawPlayerNumbers);
        List<Integer> playerNumbers = InputConverter.splitToInt(PLAYER_NUMBER_DELIMITER, rawPlayerNumbers);
        return new PlayerNumberDto(playerNumbers);
    }

    private static void validatePlayerNumbers(String rawPlayerNumbers) {
        InputValidator.validateBlank(rawPlayerNumbers);
        InputValidator.validateNumberFormat(rawPlayerNumbers);
    }

    private static class LazyHolder {

        private static final InputView INSTANCE = new InputView();

    }

}
