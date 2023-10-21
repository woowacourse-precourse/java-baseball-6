package util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

/**
 * description: 랜덤한 숫자들을 생성하는 클래스
 */
public class NumberGenerator {
    /**
     * description: 생성할 숫자의 길이
     */
    private final int numberLength;
    /**
     * description: 생성할 숫자의 최소값
     */
    private final int minNumber;
    /**
     * description: 생성할 숫자의 최대값
     */
    private final int maxNumber;

    /**
     * description: NumberGenerator의 생성자
     *
     * @param numberLength 생성할 숫자의 길이
     * @param minNumber    생성할 숫자의 최소값
     * @param maxNumber    생성할 숫자의 최대값
     */
    public NumberGenerator(int numberLength, int minNumber, int maxNumber) {
        this.numberLength = numberLength;
        this.minNumber = minNumber;
        this.maxNumber = maxNumber;
    }

    /**
     * description: 랜덤한 숫자들을 생성하는 메소드
     *
     * @return 랜덤한 숫자들을 저장하는 리스트
     */
    public List<Integer> generate() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < this.numberLength) {
            int randomNumber = Randoms.pickNumberInRange(this.minNumber, this.maxNumber);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }
}
