package baseball;

import java.util.ArrayList;
import java.util.List;

import static baseball.Exception.*;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Viewer {
    public static int readNumber() {
        return Integer.parseInt(readLine());
    }

    public static String readString() {
        return readLine();
    }
    public static boolean readIsFinish() {
        int input = readNumber();
        validateFinishGameNumber(input);
        return input == 2;
    }

    public static List<Integer> readNumbers() {
        String inputString = readString();
        return changeStringToList(inputString);
    }

    public static List<Integer> changeStringToList(String input) {
        String[] strings = input.split("");
        validateInputSize(strings);
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < strings.length; i++) {
            int number = Integer.parseInt(strings[i]);
            validateNumber(list, number);
            list.add(number);
        }
        return list;
    }

    private static void validateInputSize(String[] strings) {
        if (strings.length != 3)
            throw new IllegalArgumentException(INVALID_SIZE_OF_INPUT.getMessage());
    }

    private static void validateNumber(final List<Integer> list, final int number) {
        validateNull(number);
        validateNumberRange(number);
        validateDuplication(list, number);
    }

    private static void validateNull(int number) {
        if (number == 0)
            throw new IllegalArgumentException(INVALID_TYPE_OF_INPUT.getMessage());
    }

    private static void validateNumberRange(final int number) {
        if (number < 1 || number > 9)
            throw new IllegalArgumentException(INVALID_RANGE_OF_INPUT.getMessage());
    }

    private static void validateDuplication(final List<Integer> randomNumberList, final int number) {
        if (randomNumberList.contains(number))
            throw new IllegalArgumentException(ALREADY_EXIST_NUMBER.getMessage());
    }

    private static void validateFinishGameNumber(int input) {
        if (input != 1 && input != 2)
            throw new IllegalArgumentException(ONLY_1_OR_2.getMessage());
    }

}
