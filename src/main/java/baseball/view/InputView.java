package baseball.view;

import static baseball.model.ExceptionMessage.NUMBER_FORMAT_EXCEPTION_MESSAGE;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.Stream;
import baseball.dto.request.GameRestartOptionDto;
import baseball.dto.request.PlayerBaseballNumbersDto;
import baseball.util.BlankValidator;
import baseball.util.DigitsOnlyValidator;
import baseball.util.SingleDigitValidator;
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

    public PlayerBaseballNumbersDto readPlayerBaseBallNumbers() {
        System.out.print(INPUT_PLAYER_NUMBER_MESSAGE);
        String rawPlayerBaseBallNumbers = Console.readLine();
        validatePlayerBaseBallNumbers(rawPlayerBaseBallNumbers);
        List<Integer> playerBaseBallNumbers = splitToInt(PLAYER_NUMBER_DELIMITER, rawPlayerBaseBallNumbers);
        return new PlayerBaseballNumbersDto(playerBaseBallNumbers);
    }

    private void validatePlayerBaseBallNumbers(String rawPlayerNumbers) {
        BlankValidator.validate(rawPlayerNumbers);
        DigitsOnlyValidator.validate(rawPlayerNumbers);
    }

    private List<Integer> splitToInt(String delimiter, String input) {
        return Stream.of(input.split(delimiter))
                .map(Integer::parseInt)
                .collect(toList());
    }

    public GameRestartOptionDto readGameRestartOption() {
        System.out.println(INPUT_GAME_RESTART_MESSAGE);
        String rawGameRestartOption = Console.readLine();
        validateGameRestartOption(rawGameRestartOption);
        int gameRestartOption = convertToInt(rawGameRestartOption);
        return new GameRestartOptionDto(gameRestartOption);
    }

    private void validateGameRestartOption(String rawGameRestart) {
        BlankValidator.validate(rawGameRestart);
        SingleDigitValidator.validate(rawGameRestart);
    }

    private int convertToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_EXCEPTION_MESSAGE);
        }
    }

    private static class LazyHolder {

        private static final InputView INSTANCE = new InputView();

    }

}
