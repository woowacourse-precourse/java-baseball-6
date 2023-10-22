package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
public class Computer {
    private final Count answer;

    public Computer(Count answer) {
        this.answer = answer;
    }

    public Computer(){
        this.answer = Count.provideCount(generateRandomCount());
    }
    private String generateRandomCount(){
        List<Integer> numbers = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 9; i++) {
            numbers.add(i);
        }

        for (int i = 0; i < 3; i++) {
            int deleteIndex = Randoms.pickNumberInRange(0, numbers.size()-1);
            sb.append(numbers.remove(deleteIndex));
        }

        return sb.toString();
    }
}
