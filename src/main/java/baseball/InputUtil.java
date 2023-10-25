package baseball;

import baseball.Constant.InputType;
import camp.nextstep.edu.missionutils.Console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

import static baseball.Constant.InputType.*;

public class InputUtil {

    static String getUserInput(InputType inputType) {
        String inputString = Console.readLine();
        HashSet<Character> visited = new HashSet<>();
        if (inputType == ANSWER) {
            if (inputString.length() != 3) {
                throw new IllegalArgumentException();
            }
            for (int i = 0; i < 3; i++) {
                char c = inputString.charAt(i);
                if (!Character.isDigit(c)) {
                    throw new IllegalArgumentException();
                } else {
                    if (c == '0') {
                        throw new IllegalArgumentException();
                    }
                    visited.add(c);
                    if (visited.size() != i + 1) {
                        throw new IllegalArgumentException();
                    }
                }
            }
        } else {
            if (!inputString.equals(Constant.RESTART) && !inputString.equals(Constant.END)) {
                throw new IllegalArgumentException();
            }
        }
        return inputString;
    }
}