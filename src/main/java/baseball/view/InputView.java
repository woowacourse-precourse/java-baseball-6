package baseball.view;

import baseball.domain.GameCommand;
import baseball.view.console.ConsoleReader;
import baseball.view.console.ConsoleWriter;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public List<Integer> enterNumbers() {
        ConsoleWriter.printMessage("숫자를 입력해주세요 : ");
        return Validator.validateNumbers(ConsoleReader.enterMessage());
    }

    public GameCommand enterRestartOrQuit() {
        ConsoleWriter.printlnMessage("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return GameCommand.from(ConsoleReader.enterMessage());
    }

    private static class Validator {
        private static List<Integer> validateNumbers(String message) {
            List<String> numbers = parseStringToList(message, "");

            return numbers.stream()
                    .map(baseball.global.validator.Validator::validateNumber)
                    .toList();
        }

        private static List<String> parseStringToList(String message, String separator) {
            return Arrays.stream(split(message, separator)).toList();
        }

        private static String[] split(String message, String separator) {
            return message.split(separator);
        }
    }
}
