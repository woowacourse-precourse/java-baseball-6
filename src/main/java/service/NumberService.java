package service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.*;
import static domain.NumberConstant.*;
import static java.lang.Integer.*;

public class NumberService {
    public static List<Integer> generateComputerNumber(int size) {
        List<Integer> comNumbers = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            int num = Randoms.pickNumberInRange(START_RANGE, END_RANGE);

            if (!comNumbers.contains(num))
                comNumbers.add(num);
        }

        return comNumbers;
    }

    public static List<Integer> readInputNumber(int size) {
        List<Integer> inputNumbers = new ArrayList<>();

        String input = readLine();

        validateInput(input);

        for (int i = 0; i < size; i++)
            inputNumbers.add(input.charAt(i) - '0');

        return inputNumbers;
    }

    public static int readRestartNumber() {
        String input = readLine();

        validateRestart(input);

        return parseInt(input);
    }

    private static void validateRestart(String input) {

    }

    private static void validateInput(String input) {

    }
}
