package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String USER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final int NUMBER_POSITIONS = 10;
    private static final int SELECTION_COUNT = 3;


    // 맨 처음 시작할 때, 메시지 출력하기
    public static void getStartMessage() {
        System.out.println(START_MESSAGE);
    }

    // 유저가 세 숫자를 입력할 때, 배열로 넣어주기
    public static int[] userInputNumber() {
        System.out.print(USER_INPUT_MESSAGE);

        try {
            String input = Console.readLine();

            checkInput(input);

            int[] userInput = convertInputFormat(input);

            return userInput;
        } catch (IllegalArgumentException e) {

            throw new IllegalArgumentException(e.getMessage());

        }
    }

    // 세 숫자를 배열에 넣어주기
    public static int[] convertInputFormat(String input) {

        int[] userInput = new int[NUMBER_POSITIONS];
        int index = 0;


        for (int i = 0; i < SELECTION_COUNT; i++) {

            int eachNumber = input.charAt(i) - '0';

            checkInputDuplicate(userInput, eachNumber);

            userInput[eachNumber]+= ++index;

        }

        return userInput;

    }

    public static void checkInput(String input) {

        checkInputLength(input);

        checkInputNotNumber(input);

    }

    // Input이 세자리가 아닌 수 예외처리하기
    public static void checkInputLength(String input) {

        if (input.length() != SELECTION_COUNT) {

            throw new IllegalArgumentException("길이가 너무 짧습니다!");

        }
    }

    // Input이 1~9가 아닌 수 또는 문자라면 예외처리하기
    public static void checkInputNotNumber(String input) {

        for (char eachNumber : input.toCharArray()) {

            if (eachNumber < 49 || eachNumber > 57) {

                throw new IllegalArgumentException("올바른 숫자가 아닙니다");

            }

        }

    }

    // 세 숫자 중 하나라도 중복 예외처리하기
    public static void checkInputDuplicate(int[] userInput, int eachNumber) {

        if (userInput[eachNumber] != 0) {

            throw new IllegalArgumentException("중복된 숫자가 있습니다");

        }


    }
}
