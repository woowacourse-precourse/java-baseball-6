package game;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class NumberGenerator {

    public String generate() {
        //HashSet<Character> set = new HashSet<>();
        List<Integer> computer = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

//        while (set.size() < NumberBaseballGame.getNumberLength()) {
//            char randomDigit = (char) ('0' + RANDOM.nextInt(10));
//            if (set.add(randomDigit)) {
//                sb.append(randomDigit);
//            }
//        }
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
                sb.append(randomNumber);
            }
        }

        return sb.toString();
    }
}
