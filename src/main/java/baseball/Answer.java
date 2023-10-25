package baseball;

import java.util.ArrayList;
import java.util.List;

/**
 * Answer는 야구 게임 답안을 나타낸다.
 * 항상 올바른 형식을 가짐을 보장한다.
 */
public class Answer {

    private final int answer;

    /**
     * 전달받은 정수가 야구 게임 답안을 표현하는 유효한 정수인 경우에만 Answer 객체를 생성한다.
     *
     * @param answer 야구 게임 답안을 표현하는 세 자리 정수
     * @throws IllegalArgumentException 주어진 정수가 유효한 야구 게임 답안이 될 수 없는 경우
     */
    public Answer(int answer) throws IllegalArgumentException {
        this.answer = answer;
        List<Integer> splited = splitSelf();

        boolean isThereZeros = splited.contains(0);
        boolean isDigitDuplicated = splited.stream().distinct().count() < 3;
        boolean isNotNumOfDigitsThree = (answer < 123 || answer > 987);

        if (isThereZeros || isDigitDuplicated || isNotNumOfDigitsThree) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 자기자신과 주어진 답안을 비교했을 때의, 스트라이크 수를 반환한다.
     *
     * @param answer 주어진 답안
     * @return 스트라이크 수
     */
    public int countStrike(Answer answer) {
        int strikes = 0;
        List<Integer> self = this.splitSelf();
        List<Integer> given = answer.splitSelf();
        for (int i = 0; i < 3; i++) {
            if (self.get(i).equals(given.get(i))) {
                strikes++;
            }
        }
        return strikes;
    }

    /**
     * 자기자신과 주어진 답안을 비교했을 때의, 볼 수를 반환한다.
     *
     * @param answer 주어진 답안
     * @return 볼 수
     */
    public int countBall(Answer answer) {
        int balls = 0;
        List<Integer> self = this.splitSelf();
        List<Integer> given = answer.splitSelf();
        for (int i = 0; i < 3; i++) {
            int k = (i + 1) % 3;
            int j = (i + 2) % 3;
            if (self.get(i).equals(given.get(k))
                    || self.get(i).equals(given.get(j))) {
                balls++;
            }
        }
        return balls;
    }

    /**
     * 답안의 각 자리 숫자를 분리하여 반환한다.
     *
     * @return List<Integer> 높은 자리 숫자가 앞에 저장된 정수 리스트
     */
    public List<Integer> splitSelf() {
        List<Integer> splited = new ArrayList<>();
        splited.add(answer / 100);
        splited.add((answer / 10) % 10);
        splited.add(answer % 10);
        return splited;
    }
}
