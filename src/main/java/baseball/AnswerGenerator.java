package baseball;

import static baseball.GameClient.BALL_LENGTH;
import static baseball.GameClient.RANGE_MAXIMUM_VALUE;
import static baseball.GameClient.RANGE_MINIMUM_VALUE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 숫자야구의 정답을 만드는 클래스.
 * <p>세 자리 정답 수를 랜덤하게 결정하되, 같은 수가 등장하면 안 된다. 랜덤 값 추출은 <code>{@link Randoms}</code> API를
 * 사용한다.
 */
public class AnswerGenerator {

    public static List<Integer> createAnswer() {
        HashSet<Integer> answerNumbers = new HashSet<>();
        while (answerNumbers.size() < BALL_LENGTH) {
            int pickedNumber = Randoms.pickNumberInRange(RANGE_MINIMUM_VALUE, RANGE_MAXIMUM_VALUE);
            answerNumbers.add(pickedNumber);
        }
        return new ArrayList<>(answerNumbers);
    }
}
