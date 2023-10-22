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


    private enum Message {
        INPUT_USER_NUMBER("숫자를 입력해주세요 : ");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }

}
