package baseball.feature;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberMaker {
    public List<Integer> maker() {
        // 숫자를 담을 리스트 생성
        // 리스트에 숫자가 3개가 차면 종료 (반복)
        // 1~9 랜덤한 수 생성
        // 리스트 내부에 존재하지 않는수라면 리스트에 담기

        List<Integer> computerNumbers = new ArrayList<>();
        //1~9 숫자 생성
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            // 서로 다른 임의의 수인지 확인
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
        return computerNumbers;
    }
}