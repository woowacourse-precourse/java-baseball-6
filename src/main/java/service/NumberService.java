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
        List<Integer> randomNumbers = new ArrayList<>();

        while (randomNumbers.size() < size) {
            int num = Randoms.pickNumberInRange(START_RANGE_NUM, END_RANGE_NUM);

            if (!randomNumbers.contains(num))
                randomNumbers.add(num);
        }

        return randomNumbers;
    }

    public static List<Integer> readInputNumber(int size) {
        List<Integer> inputNumbers = new ArrayList<>();

        String inputString = readLine();

        validateInputString(inputString, size);

        for (int i = 0; i < size; i++)
            inputNumbers.add(inputString.charAt(i) - '0');

        validateInputNumbers(inputNumbers);

        return inputNumbers;
    }

    public static int readRestartNumber() {
        String input = readLine();

        validateRestartNumber(input);

        return parseInt(input);
    }

    private static void validateInputString(String inputStr, int size) {
        // input string size 검사
        if (inputStr.length() != size)
            throw new IllegalArgumentException(WRONG_INPUT_SIZE_ERROR + "\n필요 : " + size + " 실제 : " + inputStr.length());

        // input string type 검사
        for (int i = 0; i < inputStr.length(); i++) {
            char c = inputStr.charAt(i);

            if (c - '0' < START_RANGE_NUM || c - '0' > END_RANGE_NUM)
                throw new IllegalArgumentException(WRONG_INPUT_TYPE_ERROR + "\n입력 중 최초 원인 : " + c);
        }
    }

    private static void validateInputNumbers(List<Integer> inputNumbers) {
        List<Integer> duplicate = new ArrayList<>();

        for (Integer n : inputNumbers) {
            if (!duplicate.contains(n)) duplicate.add(n);
            else
                throw new IllegalArgumentException(SAME_INPUT_NUMBER_ERROR + "\n입력 중 최초 원인 : " + n);
        }
    }

    private static void validateRestartNumber(String input) {
        if (!input.equals("1") && !input.equals("2"))
            throw new IllegalArgumentException(WRONG_RESTART_TYPE_ERROR);
    }
}
