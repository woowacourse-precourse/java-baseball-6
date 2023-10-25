package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private final List<Integer> randomNumbers;

    /**
     * 입력한 크기에 맞추어 랜덤 정수 배열을 생성한다.
     */
    public Computer() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < 3) { // 게임에 필요한 숫자 길이만큼 반복되도록 설정
            int randomNumber = Randoms.pickNumberInRange(1, 9); // 1~9 사이의 값이 나오도록 범위 지정
            if (!randomNumbers.contains(randomNumber)) { // 중복된 값인지 확인
                randomNumbers.add(randomNumber); // 중복된 값이 아니면 추가
            }
        }

        this.randomNumbers = randomNumbers; // 생성된 정수 리스트를 저장
    }

    /**
     * @return 컴퓨터의 랜덤 숫자를 반환한다.
     */
    public List<Integer> getRandomNumbers() {
        return randomNumbers;
    }
}
