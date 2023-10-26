package numer_generator;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    private static final String UTIL_CLASS = "Util class";
    private NumberGenerator() {
        throw new IllegalArgumentException(UTIL_CLASS);
    }

    public static String getComputersNumber(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            addRandomNumberIfNotDuplicated(computer);
        }
        StringBuilder computerBallString = new StringBuilder();
        computer.forEach(computerBallString::append);
        return computerBallString.toString();
    }

    private static void addRandomNumberIfNotDuplicated(List<Integer> computer) {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber);
        }
    }
}
