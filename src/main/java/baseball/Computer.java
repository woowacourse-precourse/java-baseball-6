package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;

public class Computer {
    // 스트라이크 횟수
    private int stateStrike = 0;
    // 볼 횟수
    private int stateBall = 0;
    // 낫싱 횟수
    private int stateNothing = 0;

    // 모든 자리의 수가 서로 다르고, 0이 포함되지 않는 숫자를 생성하는 메서드
    public int makeNumber() {
        Integer randomNumber = 0;

        while (true) {
            // 세 자리 수 중 유효한 가장 첫 번째 수 ~ 마지막 수를 범위로 설정
            randomNumber = Randoms.pickNumberInRange(123, 987);
            String[] randomNumberSplit = randomNumber.toString().split("");

            // 세 자리가 모두 다르고, 0이 포함되지 않는 경우 randomNumber를 반환한다.
            if (randomNumberSplit[0] != randomNumberSplit[1] && randomNumberSplit[1] != randomNumberSplit[2]
                    && randomNumberSplit[0] != randomNumberSplit[2] && !Arrays.asList(randomNumberSplit).contains("0")) {
                return randomNumber;
            }
        }
    }
}
