package baseball.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Console;
import baseball.constant.Constant;
import baseball.constant.errorMessage.InputError;


public class InputView {

    private static final String YES = "1";


    public static Integer[] inputPlayerBalls() {
        String input = getInput();
        validateBlank(input);
        validateNumber(input);
        return convertStrToIntArr(input);
    }

    public static Integer[] convertStrToIntArr(String input) {
        return Stream.of(input.split(""))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
    }


    private static void validateNumber(String input) {
        if (!(input.chars()
                .allMatch(Character::isDigit)))
            throw new IllegalArgumentException(InputError.WRONG_TOKEN);
    }

    private static void validateBlank(String input) {
        if (input == null || input.isBlank())
            throw new IllegalArgumentException(InputError.WRONG_BLANK);
    }

    public static Boolean gameRestart() {
        return getInput().equals(YES) ? true : false;
    }
    private static String getInput() {
        return Console.readLine();
    }
}