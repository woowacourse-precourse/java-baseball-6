package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;

public class RandomNumberGenerator {
    public String makeRandomNumber() {
        String answer ="";

        HashSet<Integer> set = new HashSet<>();

        while (set.size() != 3) {
            int number = Randoms.pickNumberInRange(1,9);
            set.add(number);
        }

        StringBuilder sb = new StringBuilder();
        for (Integer number : set) {
            sb.append(number.toString());
        }
        answer = sb.toString();
        return answer;
    }
}
