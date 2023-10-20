package baseball;

import camp.nextstep.edu.missionutils.*;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Integer> computerNums;

        computerNums = choiceComputerNums();
        //commit test

    }

    private static List<Integer> choiceComputerNums() {
        List<Integer> computerNums;
        computerNums = Randoms.pickUniqueNumbersInRange(1, 9, 3);
        return computerNums;
    }
}

