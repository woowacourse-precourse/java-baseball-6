package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class Util {
    public static int[] split(int number) {
        String[] numberStringArray = String.valueOf(number).split("");
        int[] numberIntArray = Stream.of(numberStringArray)
                .mapToInt(Integer::parseInt)
                .toArray();

        return numberIntArray;
    }

    public static List<Integer> removeByIndex(int[] intArray, int index) {
        ArrayList<Integer> intList = new java.util.ArrayList<>(Arrays.stream(intArray)
                .boxed()
                .toList());

        intList.remove(index);

        return intList;
    }

    public static int getNonOverlappingNumber(int numberCount) {
        if (numberCount > 9) {
            throw new IllegalArgumentException("각 자리가 서로 다른 숫자로 이루어진 9자리를 초과하는 숫자는 만들 수 없습니다.");
        }

        List<Integer> numberList = new LinkedList<>();

        while (numberList.size() < numberCount) {
            int newNumber = Util.pickNumberInRangeWithoutList(numberList);
            numberList.add(newNumber);
        }

        return getJoinNumber(numberList);
    }

    public static int pickNumberInRangeWithoutList(List<Integer> withoutList) {
        while (true) {
            int pickedNumber = Randoms.pickNumberInRange(1, 9);
            if (!withoutList.contains(pickedNumber)) {
                return pickedNumber;
            }
        }
    }

    public static int getJoinNumber(List<Integer> numberList) {
        int resultNumber = 0;

        for (int i = 0; i < numberList.size(); i++) {
            resultNumber += numberList.get(i) * Math.pow(10, numberList.size() - 1 - i);
        }
        return resultNumber;
    }

    public static boolean validateInputNumber(String inputString, int numberCount) {
        int inputNumber;

        try {
            inputNumber = Integer.parseInt(inputString);
        } catch (NumberFormatException e1) {
            return false;
        }

        int maxNumber = 0;
        int minNumber = (int) Math.pow(10, numberCount - 1);
        for (int i = 0; i < numberCount; i++) {
            maxNumber += 9 * Math.pow(10, i);
        }
        if (inputNumber > maxNumber || inputNumber < minNumber) {
            return false;
        }

        int[] splitNumberArray = Util.split(inputNumber);
        for (int number : splitNumberArray) {
            if (number == 0) {
                return false;
            }
        }

        boolean[] duplicateVerificationArray = new boolean[10];
        for (int number : splitNumberArray) {
            if (duplicateVerificationArray[number]) {
                return false;
            }
            duplicateVerificationArray[number] = true;
        }

        return true;
    }
}
