package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.lang.IllegalArgumentException;

public class Input {
    String answer;
    int test;
    int[] myNumber = new int[3];
    int exitNumber;

    public int ExitInput() throws IllegalArgumentException {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        try {
            answer = Console.readLine();
        } catch (Exception e) {
            throw new IllegalArgumentException("readLine error");
        }
        if (answer.length() != 1) {
            throw new IllegalArgumentException("input size error");
        }

        test = answer.charAt(0) - '0';
        if (test == 1 || test == 2) {
            exitNumber = test;
            return exitNumber;
        } else {
            throw new IllegalArgumentException("input type error");
        }
    }

    public int GameInput() throws IllegalArgumentException {
        System.out.print("숫자를 입력해주세요 : ");
        try {
            answer = Console.readLine();
        } catch (Exception e) {
            throw new IllegalArgumentException("readLine error");
        }
        if (answer.length() != 3) {
            throw new IllegalArgumentException("input size error");
        }
        for (int i = 0; i < 3; i++) {
            test = answer.charAt(i) - '0';
            if (test < 0 || test > 9) {
                throw new IllegalArgumentException("input type error");
            } else {
                myNumber[i] = test;
            }
        }
        if (myNumber[0] == myNumber[1]) {
            throw new IllegalArgumentException("repetition error");
        }
        if (myNumber[1] == myNumber[2]) {
            throw new IllegalArgumentException("repetition error");
        }
        if (myNumber[0] == myNumber[2]) {
            throw new IllegalArgumentException("repetition error");
        }
        return myNumber[0] * 100 + myNumber[1] * 10 + myNumber[2];
    }
}
