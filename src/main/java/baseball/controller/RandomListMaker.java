package baseball.controller;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomListMaker {
    private final static int MINIMUM_NUM_IN_RANGE = 1;
    private final static int MAXIMUM_NUM_IN_RANGE = 9;
    private final static int LIST_SIZE = 3;

    public static List<Integer> generateRandomNumbers() {
        List<Integer> computerNumber = new ArrayList<>();
        addComputerNumber(computerNumber);
        return computerNumber;
    }

    private static void addComputerNumber(List<Integer> computerNumber) {
        while (!isFull(computerNumber)) {
            int randomNumber = getRandomNumberInRange();
            containNumberInList(computerNumber, randomNumber);
        }
    }

    private static boolean isFull(List<Integer> computerNumber) {
        return computerNumber.size() == LIST_SIZE;
    }

    private static int getRandomNumberInRange() {
        return Randoms.pickNumberInRange(MINIMUM_NUM_IN_RANGE, MAXIMUM_NUM_IN_RANGE);
    }

    private static void containNumberInList(List<Integer> computerNumber, int randomNumber) {
        if (!computerNumber.contains(randomNumber)) {
            computerNumber.add(randomNumber);
        }
    }
}
