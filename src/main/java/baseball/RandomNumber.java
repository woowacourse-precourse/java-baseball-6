package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumber {
    private static final int NUMBER_LENGTH = 3;
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 9;

    private final List<Integer> computerNumber = new ArrayList<>();

    // 기본 생성자를 통해 computerNumber 초기화하기
    public RandomNumber() {
        createNumber();
    }

    // 랜덤으로 숫자 생성
    public int randomMake() {
        return Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
    }

    // 랜덤 컴퓨터 숫자 만들기
    public void createNumber() {
        while (computerNumber.size() < NUMBER_LENGTH) {
            int randomNumber = randomMake();
            // 중복 숫자는 포함될 수 없음
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
    }

    // computerNumber 요소 하나 가져오기
    public Integer getNumber(int index) {
        return computerNumber.get(index);
    }

    // computerNumber에 포함 됐는지 확인
    public boolean contains(Integer number){
        return computerNumber.contains(number);
    }
}
