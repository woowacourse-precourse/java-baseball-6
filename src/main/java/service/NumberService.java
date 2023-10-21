package service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.*;
import static domain.ErrorConstant.*;
import static domain.NumberConstant.*;
import static java.lang.Integer.*;

public class NumberService {
    public static List<Integer> generateRandomNumber(int size) {
        List<Integer> comNumbers = new ArrayList<>();

        while (comNumbers.size() < size) {
            int num = Randoms.pickNumberInRange(START_RANGE, END_RANGE);

            if (!comNumbers.contains(num))
                comNumbers.add(num);
        }

        return comNumbers;
    }

    public static List<Integer> readInputNumber(int size) {
        List<Integer> inputNumbers = new ArrayList<>();

        String input = readLine();

        validateInputString(input, size);

        for (int i = 0; i < size; i++)
            inputNumbers.add(input.charAt(i) - '0');

        validateInputNumbers(inputNumbers);

        return inputNumbers;
    }

    public static int readRestartNumber() {
        String input = readLine();

        validateRestart(input);

        return parseInt(input);
    }

    private static void validateInputString(String input, int size) {
        if (input.length() != size)
            throw new IllegalArgumentException(wrongInputSizeError + " 필요 : " + size + " 실제 : " + input.length());

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c < '0' || c > '9')
                throw new IllegalArgumentException(wrongInputTypeError);
        }
    }

    private static void validateInputNumbers(List<Integer> inputNumbers) {
        List<Integer> counted = new ArrayList<>();

        for (Integer n : inputNumbers) {
            if (!counted.contains(n)) counted.add(n);
            else
                throw new IllegalArgumentException(sameInputNumberError);
        }
    }

    private static void validateRestart(String input) {
        if (!input.equals("1") && !input.equals("2"))
            throw new IllegalArgumentException(restartTypeError);
    }
}
