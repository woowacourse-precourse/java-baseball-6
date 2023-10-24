package baseball.view;

import baseball.valueObject.BallInfo;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public static final String MESSAGE_ASK_USER_INPUT = "숫자를 입력해주세요 : ";
    private static final String MESSAGE_WELCOME = "숫자 야구 게임을 시작합니다.";
    public static final int FORMAL_INPUT_LENGTH = 3;
    private static final String NUMBER_CHECK = "^[1-9]{3}$";

    public static BallInfo getBallFromUserInput() {
        System.out.print(MESSAGE_ASK_USER_INPUT);
        return validateUserInput(Console.readLine());
    }

    public static void welcomeMessage() {
        System.out.println(MESSAGE_WELCOME);
    }

    private static void validateInputLength(String userInput) {
        if (userInput.length() != FORMAL_INPUT_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateInputIsNumber(String userInput) {
        if (!userInput.matches(NUMBER_CHECK)) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateInputDuplication(String userInput) {
        ArrayList<String> ball = new ArrayList<>(Arrays.asList(userInput.split("")));
        ball = new ArrayList<String>(ball.stream().distinct().collect(Collectors.toList()));
        if (ball.size() != FORMAL_INPUT_LENGTH) {
            throw new IllegalArgumentException();
        }

    }

    private static BallInfo validateUserInput(String userInput) {
        validateInputLength(userInput);
        validateInputIsNumber(userInput);
        validateInputDuplication(userInput);

        return getBallFromUserInput(userInput);
    }

    private static BallInfo getBallFromUserInput(String userInput) {
        List<Integer> userInputList = new ArrayList<>();
        for (Character character : userInput.toCharArray()) {
            userInputList.add(Integer.parseInt(String.valueOf(character)));
        }
        return new BallInfo(userInputList);
    }


}
