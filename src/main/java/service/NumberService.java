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

        validateInputType(inputString);
        validateInputSize(inputString, size);

        for (int i = 0; i < size; i++)
            inputNumbers.add(inputString.charAt(i) - '0');

        validateInputDuplicate(inputNumbers);

        return inputNumbers;
    }

    public static int readRestartNumber() {
        String input = readLine();

        validateInputType(input);
        validateInputSize(input, RESTART_INPUT_SIZE);
        validateRestartNumber(input);

        return parseInt(input);
    }

    public static void validateInputSize(String input, int size) {
        if (input.length() != size)
            throw new IllegalArgumentException(INPUT_SIZE_ERROR + "\n필요 : " + size + " 실제 : " + input.length());
    }

    public static void validateInputType(String input) {
        for (int i = 0; i < input.length(); i++) {
            int digit = input.charAt(i);

            if (digit - '0' < START_RANGE_NUM || digit - '0' > END_RANGE_NUM)
                throw new IllegalArgumentException(INPUT_TYPE_ERROR + "\n입력 중 최초 원인 : " + digit);
        }
    }

    public static void validateInputDuplicate(List<Integer> inputNumbers) {
        List<Integer> duplicate = new ArrayList<>();

        for (Integer n : inputNumbers) {
            if (!duplicate.contains(n)) duplicate.add(n);
            else
                throw new IllegalArgumentException(SAME_INPUT_NUMBER_ERROR + "\n입력 중 최초 원인 : " + n);
        }
    }

    public static void validateRestartNumber(String input) {
        int restartNumber = parseInt(input);

        if (restartNumber != RESTART_INPUT_NUM && restartNumber != QUIT_INPUT_NUM)
            throw new IllegalArgumentException(RESTART_TYPE_ERROR);
    }
}
