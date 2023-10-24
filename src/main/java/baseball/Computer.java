package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Computer {
    // 랜덤으로 뽑을 숫자 범위 상수 지정
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;
    // 컴퓨터가 가지고 있는 숫자
    public static List<Integer> computerNumber = new ArrayList<>();
    // 스트라이크 횟수
    public static int stateStrike = 0;
    // 볼 횟수
    public static int stateBall = 0;
    // 낫싱 횟수
    public static int stateNothing = 0;

    // 모든 자리의 수가 서로 다르고, 0이 포함되지 않는 숫자를 생성하는 메서드
    public void makeNumber() {
        // 세 자리 수를 만든다.
        while (computerNumber.size() < 3) {
            // 랜덤한 숫자를 생성한다.
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            // 컴퓨터가 가지고 있지 않은 숫자라면 넣어준다.
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
    }

    public static int getStateStrike() {
        return stateStrike;
    }

    public static void resetState() {
        stateStrike = 0;
        stateBall = 0;
        stateNothing = 0;
    }

    public static void resetComputerNumber() {
        computerNumber.clear();
    }

    public void checkNumber(List<Integer> computerNumber, List<Integer> playerNumber) {
        String hint = "";

        for (int i = 0; i < 3; i++) {
            // 볼이 있는지 검사
            // 만약 플레이어가 입력한 숫자 중 i번째가 컴퓨터가 가지고 있는 숫자에 포함되면 볼 횟수 증가
            if (computerNumber.contains(playerNumber.get(i))) {
                stateBall += 1;
            } else {
                stateNothing += 1;
            }

            // 스트라이크가 있는지 검사
            // 스트라이크가 존재하면 볼 횟수 감소, 스트라이크 횟수 증가
            if (computerNumber.get(i) == playerNumber.get(i)) {
                stateStrike += 1;
                stateBall -= 1;
            }
        }

        if (stateBall != 0) {
            hint += stateBall + "볼 ";
        }

        if (stateStrike != 0) {
            hint += stateStrike + "스트라이크";
        }

        if (stateNothing == 3) {
            hint = "낫싱";
        }
        System.out.println(hint);
    }
}
