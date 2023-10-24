package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballModel {

    int digit = 3;
    String strikeComment = "스트라이크";
    String ballComment = "볼";
    String nothingComment = "낫싱";
    String resultComment = "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    List<Integer> computer;
    int ball, strike;

    public void createNumber() { //컴퓨터가 생성하는 서로 다른 세 자리의 숫자
        computer = new ArrayList<>();
        while (computer.size() < digit) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    public void getBallCount(String insert) { //사용자 입력값과 컴퓨터의 값을 비교하여 볼, 스트라이크 갯수를 판단
        List<Integer> list = new ArrayList<>();
        ball = 0;
        strike = 0;

        for (int i = 0; i < digit; i++) {
            list.add(Integer.parseInt(String.valueOf(insert.charAt(i))));
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(computer.get(i))) {
                strike++;
            }
            else if (list.contains(computer.get(i))) {
                ball++;
            }
        }
    }

    public String getStringResult() { //입력한 수에 대한 결과 출력
        StringBuilder sb = new StringBuilder();
        if (strike == 0 && ball == 0) { //하나도 없는 경우
            return nothingComment;
        }

        if (ball != 0) {
            sb.append(ball).append(ballComment).append(" ");
        }
        if (strike != 0) {
            sb.append(strike).append(strikeComment).append("\n");
        }
        if (strike == digit) {
            sb.append(digit).append(resultComment);
        }

        return String.valueOf(sb);
    }
}
