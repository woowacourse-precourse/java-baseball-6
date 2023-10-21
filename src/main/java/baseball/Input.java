package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.lang.IllegalArgumentException;

public class Input {

    public static int ExitInput() throws IllegalArgumentException {
        String answer;
        ExitPrint();
        answer = ReadLineError();
        InputSizeError(answer, 1);
        return IntInputTypeError(answer);
    }

    public static int GameInput() throws IllegalArgumentException {
        String answer;
        int[] myNumber;
        GamePrint();
        answer = ReadLineError();
        InputSizeError(answer, 3);
        myNumber = InputTypeError(answer);
        RepetitionError(myNumber);
        return myNumber[0] * 100 + myNumber[1] * 10 + myNumber[2];
    }

    static void RepetitionError(int[] arr) throws IllegalArgumentException {
        if (arr[0] == arr[1]) {
            throw new IllegalArgumentException("repetition error");
        }
        if (arr[1] == arr[2]) {
            throw new IllegalArgumentException("repetition error");
        }
        if (arr[0] == arr[2]) {
            throw new IllegalArgumentException("repetition error");
        }
    }

    static int[] InputTypeError(String answer) throws IllegalArgumentException {
        int[] result = new int[3];
        int test;
        for (int i = 0; i < 3; i++) {
            test = answer.charAt(i) - '0';
            if (test < 1 || test > 9) {
                throw new IllegalArgumentException("input type error");
            } else {
                result[i] = test;
            }
        }
        return result;
    }

    static int IntInputTypeError(String answer) throws IllegalArgumentException {
        int test;
        test = answer.charAt(0) - '0';
        if (test == 1 || test == 2) {
            return test;
        } else {
            throw new IllegalArgumentException("input type error");
        }
    }

    static void InputSizeError(String answer, int criticalPoint) throws IllegalArgumentException {
        if (answer.length() != criticalPoint) {
            throw new IllegalArgumentException("input size error");
        }
    }

    static String ReadLineError() throws IllegalArgumentException {
        try {
            return Console.readLine();
        } catch (Exception e) {
            throw new IllegalArgumentException("readLine error");
        }
    }

    static void GamePrint() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    static void ExitPrint() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }


}
