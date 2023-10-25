package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> computerAnswer = createRandomAnswer();
    }

    private static List<Integer> createRandomAnswer() {

        final int MIN_NUMBER = 1;
        final int MAX_NUMBER = 9;
        final List<Integer> computerAnswer = new ArrayList<>();

        while (computerAnswer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!computerAnswer.contains(randomNumber)) {
                computerAnswer.add(randomNumber);
            }
        }
        
        return computerAnswer;
    }

}
