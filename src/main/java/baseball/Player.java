package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

/**
 * 숫자 야구 게임을 진행하기 위한 클래스.
 */
public class Player {
    private final List<Integer> numbers;

    /**
     * 무작위 숫자를 가지는 Player 객체를 생성합니다.
     *
     * @param preference 자릿수, 각 자리 범위를 담은 Preference 객체
     */
    public Player(Preference preference) {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < preference.answerSize()) {
            int randomNumber = Randoms.pickNumberInRange(preference.lowerBound(), preference.upperBound());
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        this.numbers = numbers;
    }

    /**
     * 주어진 리스트와 같은 숫자를 가지는 Player 객체를 생성합니다.
     *
     * @param numbers 제공할 리스트
     */
    public Player(List<Integer> numbers) {
        this.numbers = numbers;
    }

    /**
     * 해당 객체가 특정 숫자를 가지고 있는지 확인합니다. 가장 왼쪽 자리의 위치는 1이며, 가장 오른쪽 자리의 위치는 size입니다.
     *
     * @param target 찾을 숫자
     * @return target을 가지고 있다면 해당 위치, 그렇지 않다면 0을 반환합니다.
     */
    public int containsNumber(int target) {
        return numbers.indexOf(target) + 1;
    }

    /**
     * 자신과 another 객체의 숫자값을 비교합니다.
     *
     * @param another 비교할 대상
     * @return [strike 개수, ball 개수]를 나타내는 Result 객체
     */
    public Result compareWith(Player another) {
        int strike = 0;
        int ball = 0;

        for (int i = 1; i <= numbers.size(); i++) {  // i번째 자리 숫자 확인
            int myNumber = numbers.get(i - 1);
            int anotherNumberAt = another.containsNumber(myNumber);
            if (anotherNumberAt == i) {  // strike
                strike++;
            } else if (anotherNumberAt > 0) {  // ball
                ball++;
            }
        }
        return new Result(strike, ball);
    }
}
