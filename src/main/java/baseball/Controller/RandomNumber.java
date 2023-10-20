package baseball.Controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

/*
1. 랜덤수는 총 3자리 수
2. 리스트에 저장해서 각각의 숫자를 비교할 수 있게 하기
3. 반복문을 사용해서 리스트에 저장하기
4. 랜덤수는 1~9까지 / 중복되지 않는다.
5. 예제는 이해하고 새로운 코드로 작성하기
 */
public class RandomNumber {
    //랜덤 숫자 생성 메소드 생성
    public List<Integer> generateGameNumbers() {
        List<Integer> randomNumbers = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            randomNumbers.add(generateRandomGameNumber(randomNumbers));
        }
        return randomNumbers;
    }

    //camp.nextstep.edu.missionutils에서 제공하는 Randoms API 사용하여 중복되지 않는 랜덤 수 저장
    private int generateRandomGameNumber(List<Integer> randomNumbers) {
        while (true) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (notDuplication(randomNumbers, randomNumber)) {
                return randomNumber;
            }
        }
    }

    //생성된 랜덤변수가 중복 숫자인지 판단
    private boolean notDuplication(List<Integer> randomNumbers, int randomNumber) {
        return !randomNumbers.contains(randomNumber);
    }
}
