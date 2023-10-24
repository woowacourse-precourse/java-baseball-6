package baseball.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {

    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String USER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final int SELECTION_COUNT = 3;


    // 맨 처음 시작할 때, 메시지 출력하기
    public static void getStartMessage() {

        System.out.println(START_MESSAGE);

    }

    // 유저가 세 숫자를 입력할 때, 배열로 넣어주기
    public static List<Integer> userInputNumber() {

        System.out.print(USER_INPUT_MESSAGE);

        try {
            String input = Console.readLine();

            checkInput(input, SELECTION_COUNT);

            List<Integer> userInput = convertInputFormat(input);

            return userInput;

        } catch (IllegalArgumentException e) {

            throw new IllegalArgumentException(e.getMessage());

        }
    }


    public static void checkInput(String input, int inputLength) {

        checkInputLength(input, inputLength);

        checkInputNotNumber(input);

    }


    // 세 숫자를 배열에 넣어주기
    private static List<Integer> convertInputFormat(String input) {

        List<Integer> userInput = new ArrayList<>();

        for (int i = 0; i < SELECTION_COUNT; i++) {

            int eachNumber = input.charAt(i) - '0';

            checkInputDuplicate(userInput, eachNumber);

            userInput.add(eachNumber);

        }

        return userInput;

    }

    // Input이 세자리가 아닌 수 예외처리하기
    private static void checkInputLength(String input, int inputLength) {

        if (input.length() != inputLength) {

            throw new IllegalArgumentException("길이가 너무 짧습니다!");

        }
    }

    // Input이 1~9가 아닌 수 또는 문자라면 예외처리하기
    private static void checkInputNotNumber(String input) {

        for (char eachNumber : input.toCharArray()) {

            if (eachNumber < 49 || eachNumber > 57) {

                throw new IllegalArgumentException("올바른 숫자가 아닙니다");

            }

        }

    }

    // 세 숫자 중 하나라도 중복 예외처리하기
    private static void checkInputDuplicate(List<Integer> userInput, int eachNumber) {

        if (userInput.contains(eachNumber)) {

            throw new IllegalArgumentException("중복된 숫자가 있습니다");

        }

    }
}
