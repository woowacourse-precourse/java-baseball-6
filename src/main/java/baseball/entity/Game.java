package baseball.entity;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private String answer;

    //랜덤 정답 초기화
    public void initAnswer() {
        List<Integer> integers = new ArrayList<>();
        while (integers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!integers.contains(randomNumber)) {
                integers.add(randomNumber);
            }
        }
        this.answer = "";
        for (Integer integer : integers) {
            this.answer += integer.toString();
        }
    }

    //스트라이크 카운트
    public int countStrike(String inputString) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (inputString.charAt(i) == this.answer.charAt(i)) {
                count += 1;
            }
        }
        return count;
    }

    //볼 카운트
    public int countBall(String inputString) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (inputString.charAt(i) != this.answer.charAt(i) && this.answer.contains(String.valueOf(inputString.charAt(i)))) {
                count += 1;
            }
        }
        return count;
    }

    //정답 판별
    public boolean isAnswer(String inputString) {
        if (countStrike(inputString) == 3) {
            return true;
        }
        return false;
    }


}
