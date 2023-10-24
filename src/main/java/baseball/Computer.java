package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static baseball.constants.Rule.*;

public class Computer {
    private List<Integer> numbers;

    public Computer() {
        numbers = new ArrayList<>();
    }

    /**
     * 숫자 리스트 초기화
     */
    private void init() {
        numbers.clear();
    }

    /**
     * 랜덤 숫자 리스트 생성
     */
    public void generateNumbers() {
        this.init();
        while (numbers.size() < PICK_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
    }

    /**
     * 사용자 입력과 랜덤 숫자 리스트 비교
     *
     * @param input
     * @return
     */
    public Map<BaseBallType, Integer> compareNumbers(String input) {
        int ballCount = 0, strikeCount = 0;

        for (int i = 0; i < PICK_SIZE; i++) {
            int inputNumber = input.charAt(i) - '0';
            if (numbers.get(i) == inputNumber) {
                strikeCount++;
            } else if (numbers.contains(inputNumber)) {
                ballCount++;
            }
        }
        return Map.of(BaseBallType.BALL, ballCount, BaseBallType.STRIKE, strikeCount);
    }

    /**
     * 랜덤 숫자 리스트 반환
     *
     * @return 랜덤 숫자 리스트
     */
    public String getNumbers() {
        return numbers.toString();
    }
}
