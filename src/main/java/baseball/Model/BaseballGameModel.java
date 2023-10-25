package baseball.Model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballGameModel {
    public List<Integer> answerNums; // 컴퓨터가 가지고 있는 정답 숫자

    public List<Integer> getAnswerNums() {
        return answerNums;
    }

    // 기본 생성자 선언.
    public BaseballGameModel() {
        this.answerNums = pickThreeNumbers(); // 컴퓨터가 가질 정답 숫자를 생성한다.
    }

    // 1. 컴퓨터가 가질 3개의 값을 초기화하는 메서드
    public List<Integer> pickThreeNumbers() {
        List<Integer> computerNums = new ArrayList<>();
        while (computerNums.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNums.contains(randomNumber)) {
                computerNums.add(randomNumber);
            }
        }
        return computerNums;
    }

    // 5. 입력한 수에 대한 결과를 볼, 스트라이크 개수로 출력하는 메서드
    public String calculateResult(String[] playerNums,
                                  List<Integer> computerNums) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < playerNums.length; i++) {
            Integer num = Integer.parseInt(playerNums[i]);
            if (computerNums.contains(num) && computerNums.get(i) == num) {
                strike += 1;
            } else if (computerNums.contains(num) && computerNums.get(i) != num) {
                ball += 1;
            }
        }

        if (strike == 3) {
            return "3스트라이크";
        } else if (strike == 2 && ball == 0) {
            return "2스트라이크";
        } else if (strike == 2 && ball == 1) {
            return "1볼 2스트라이크";
        } else if (strike == 1 && ball == 2) {
            return "2볼 1스트라이크";
        } else if (strike == 1 && ball == 1) {
            return "1볼 1스트라이크";
        } else if (strike == 1 && ball == 0) {
            return "1스트라이크";
        } else if (strike == 0 && ball == 3) {
            return "3볼";
        } else if (strike == 0 && ball == 2) {
            return "2볼";
        } else if (strike == 0 && ball == 1) {
            return "1볼";
        } else {
            return "낫싱";
        }
    }
}
