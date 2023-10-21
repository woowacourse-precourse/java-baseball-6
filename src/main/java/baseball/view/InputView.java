package baseball.view;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.Stream;
import baseball.dto.request.GameRestartDto;
import baseball.dto.request.PlayerNumberDto;
import baseball.util.InputValidator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_PLAYER_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String PLAYER_NUMBER_DELIMITER = "";
    private static final String INPUT_GAME_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private InputView() {
    }

    public static InputView getInstance() {
        return LazyHolder.INSTANCE;
    }

    public PlayerNumberDto scanPlayerNumbers() {
        System.out.print(INPUT_PLAYER_NUMBER_MESSAGE);
        String rawPlayerNumbers = Console.readLine();
        validatePlayerNumbers(rawPlayerNumbers);
        List<Integer> playerNumbers = splitToInt(PLAYER_NUMBER_DELIMITER, rawPlayerNumbers);
        return new PlayerNumberDto(playerNumbers);
    }

    private List<Integer> splitToInt(String format, String input) {
        return Stream.of(input.split(format))
                .map(Integer::parseInt)
                .collect(toList());
    }

    private static void validatePlayerNumbers(String rawPlayerNumbers) {
        InputValidator.validateBlank(rawPlayerNumbers);
        InputValidator.validateNumberFormat(rawPlayerNumbers);
    }

    public GameRestartDto scanGameRestart() {
        System.out.println(INPUT_GAME_RESTART_MESSAGE);
        String rawGameRestart = Console.readLine();
        validateGameRestart(rawGameRestart);
        int gameRestartNumber = convertToInt(rawGameRestart);
        return new GameRestartDto(gameRestartNumber);
    }

    private int convertToInt(String input) {
        return Integer.parseInt(input);
    }

    private void validateGameRestart(String rawGameRestart) {
        InputValidator.validateBlank(rawGameRestart);
        InputValidator.validateOneDigitNumber(rawGameRestart);
    }

    private static class LazyHolder {

        private static final InputView INSTANCE = new InputView();

    }

}
