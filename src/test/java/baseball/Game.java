package baseball;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private static List<Integer> answer;

    public void start(){
        System.out.println("숫자 야구 게임을 시작합니다.");
        answer = createRandomNumber();
    }

    // 랜덤 세자리 수 정답 생성
    public List<Integer> createRandomNumber() {
        List<Integer> randomNumber = new ArrayList<>();
        while(randomNumber.size() < 3) {
            int num = Randoms.pickNumberInRange(1, 9);
            if(!randomNumber.contains(num)) {
                randomNumber.add(num);
            }
        }
        return randomNumber;
    }
}