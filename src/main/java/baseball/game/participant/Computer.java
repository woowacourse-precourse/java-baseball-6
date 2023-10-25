package baseball.game.participant;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

/**
 * 컴퓨터가 생성한 임의의 정답을 저장하기 위한 클래스
 */
public class Computer {

    private final List<Integer> answer;

    private Computer(List<Integer> answer) {
        this.answer = answer;
    }

    /**
     * 임의의 새로운 정답을 만들어 Computer 객체를 생성한다.
     */
    public static Computer create() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }

        return new Computer(answer);
    }

    public List<Integer> getAnswer() {
        return this.answer;
    }

}
