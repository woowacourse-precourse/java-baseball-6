package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

// 정답 생성기
public class Computer {

    private final ArrayList<Integer> answer = new ArrayList<>();

    public ArrayList<Integer> getAnswer() {
        return new ArrayList<>(answer);
    }

    public Computer() {
        generateRandomNums();
    }

    private void generateRandomNums() {
        while (answer.size() < 3) {
            int randomNum = Randoms.pickNumberInRange(1, 9);

            if (!answer.contains(randomNum))
                answer.add(randomNum);
        }
    }

}
