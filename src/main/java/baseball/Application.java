package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Random;

public class Application {
    public String setRandomDistinctNumbers() {
        int number = Randoms.pickNumberInRange(1, 9);
        return String.valueOf(number);
    }

    public static void main(String[] args) {

    }
}
