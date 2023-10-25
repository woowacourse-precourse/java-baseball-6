package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    public static ArrayList<Integer> generateComputerNum(int NUMBER_LENGTH) {
        ArrayList<Integer> computerNumArray = new ArrayList<>();

        while (computerNumArray.size() < NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            addUniqueRandomNumber(randomNumber, computerNumArray);
        }
        return computerNumArray;
    }

    private static void addUniqueRandomNumber(int randomNumber, ArrayList<Integer> computerNumArray) {
        if (!computerNumArray.contains(randomNumber)) {
            computerNumArray.add(randomNumber);
        }
    }
}