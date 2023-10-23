package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private List<Integer> answer;  // 정답 리스트

    public Computer() {
        this.answer = new ArrayList<>();

        for(int i = 0; i < 3; i++) {
            int num = Randoms.pickNumberInRange(1, 9);

            while(answer.contains(num)) {  // 서로 다른 3자리 숫자를 구성하기 위한 로직
                num = Randoms.pickNumberInRange(1, 9);
            }

            answer.add(num);
        }
    }

    public Boolean startGame(String input) {

        Boolean isCorrect = false;
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < input.length(); i++) {  // 한 자리씩 숫자 비교 진행

            int num = Integer.parseInt(input.substring(i, i + 1));

            if (answer.contains(num) && answer.get(i) == num) {  // 스트라이크 조건
                strike += 1;
            } else if (answer.contains(num)) {  // 볼 조건
                ball += 1;
            }
        }

        if (strike == 3) {  // 정답인 경우 출력
            System.out.println(strike + "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            isCorrect = true;
        } else if (strike == 0 && ball == 0){  // 낫싱인 경우 출력
            System.out.println("낫싱");
            isCorrect = false;
        } else if (ball == 0) {  // 스트라이크만 있는 경우 스트라이크 카운트만 출력
            System.out.println(strike + "스트라이크");
            isCorrect = false;
        } else if (strike == 0) {  // 볼만 있는 경우 볼 카운트만 출력
            System.out.println(ball + "볼");
            isCorrect = false;
        } else {  //
            System.out.println(ball + "볼 " + strike + "스트라이크");
            isCorrect = false;
        }

        return isCorrect;  // 정답인 경우 true 반환, 이외에는 false 반환
    }
}