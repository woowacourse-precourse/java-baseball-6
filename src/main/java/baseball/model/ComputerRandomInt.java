package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;

public class ComputerRandomInt {
    public static String randomNum() {
        HashSet<String> computer = new HashSet<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            String randomString = String.valueOf(randomNumber);
            computer.add(randomString);
        }

        String computerString = String.join("", computer);

        return computerString;
    }
}