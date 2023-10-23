package baseball.view;

import baseball.util.ValidationUtils;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final InputView instance = new InputView();

    private InputView() {
    }

    public static InputView getInstance() {
        return instance;
    }

    public List<Integer> readUserNumber() {
        System.out.print(Message.INPUT_USER_NUMBER.message);
        String input = ValidationUtils.validUserNumber(Console.readLine());

        return convertToNumberList(input);
    }

    private static List<Integer> convertToNumberList(String input) {
        return Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public String readRetryCommand() {
        System.out.println(Message.INPUT_GAME_RETRY.message);
        return Console.readLine();
    }


    private enum Message {
        INPUT_USER_NUMBER("숫자를 입력해주세요 : "),
        INPUT_GAME_RETRY("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }

}
