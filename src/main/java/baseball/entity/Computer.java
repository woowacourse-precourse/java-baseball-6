package baseball.entity;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;

public class Computer {
    private final int numberLength = 3;
    String answer;

    public Computer() {
        answer = "";
    }

    public void setAnswer() {
        answer = "";
        HashSet<Integer> set = new HashSet<>();
        while (set.size() != numberLength) {
            set.add(Randoms.pickNumberInRange(1, 9));
        }
        for (int i : set) {
            answer += i;
        }
    }

    public String getAnswer() {
        return answer;
    }
}
