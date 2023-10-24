package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int DIGIT_COUNT = 3;

    public static void main(String[] args) {
    }


    public static ArrayList<Integer> getRandomNumber() {
        ArrayList<Integer> answerNumberList = new ArrayList<>();

        while (answerNumberList.size() < DIGIT_COUNT) {
            checkExistsInList(Randoms.pickNumberInRange(1, 9), answerNumberList);
        }
        return answerNumberList;
    }

    public static void checkExistsInList(int number, ArrayList<Integer> list) {
        if (!list.contains(number)) {
            list.add(number);
        }
    }


}