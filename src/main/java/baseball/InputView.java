package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {

    private static final int ONE_OR_TWO_LEN = 1;
    private static final int LIST_LEN = 3;
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 9;
    private static final int CONTINUE = 1;
    private static final int END = 2;

    public static List<Integer> inputList() {
        System.out.print("숫자를 입력해주세요 : ");

        String input = Console.readLine();
        int inputLen = input.length();

        validateInputLength(input, LIST_LEN);

        List<Integer> inputList = new ArrayList<>();
        for (int i = 0; i < inputLen; i++) {
            int inputNum = input.charAt(i) - '0';

            validateNumber(inputNum);
            validateDuplication(inputList, inputNum);

            inputList.add(inputNum);
        }

        return inputList;
    }

    public static boolean inputOneOrTwo() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        
        String input = Console.readLine();

        validateInputLength(input, ONE_OR_TWO_LEN);

        int inputNum = input.charAt(0) - '0';
        validateOneOrTwo(inputNum);

        return inputNum == CONTINUE;
    }

    private static void validateOneOrTwo(int inputNum) {
        if (inputNum != CONTINUE && inputNum != END) {
            throw new IllegalArgumentException("1 또는 2 만 입력해야 합니다.");
        }
    }

    private static void validateDuplication(List<Integer> inputList, int inputNum) {
        if (inputList.contains(inputNum)) {
            throw new IllegalArgumentException("중복되지 않는 숫자를 입력해야 합니다.");
        }
    }

    private static void validateNumber(int inputNum) {
        if (inputNum < MIN_NUM || inputNum > MAX_NUM) {
            throw new IllegalArgumentException("1 ~ 9 범위의 숫자만 입력해야 합니다.");
        }
    }

    public static void validateInputLength(String input, int value) {
        if (input.length() != value) {
            throw new IllegalArgumentException(value + " 자리를 입력해야 합니다.");
        }
    }
}
