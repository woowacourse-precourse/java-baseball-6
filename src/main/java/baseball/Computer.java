package baseball;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Computer {
    private int answer;

    public Computer() {
        this.answer = generateAnswer();
    }

    public void updateAnswer() {
        this.answer = generateAnswer();
    }

    private Integer generateAnswer() {
        List<Integer> numList = Randoms.pickUniqueNumbersInRange(0, 9, 3);
        if(numList.get(0) == 0) {
            Collections.swap(numList, 0, 1);
        }
        String numString = numList.stream().map(String::valueOf).collect(Collectors.joining());

        System.out.println(Integer.parseInt(numString));
        return Integer.parseInt(numString);
    }
}
