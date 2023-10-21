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
    public String makeNumber() {
        Integer randomNumber = 0;

        // 랜덤한 숫자를 생성하고, 검증한 결과가 true인 동안 계속해서 랜덤 숫자를 새로 생성
        do {
            randomNumber = Randoms.pickNumberInRange(123, 987);
        }
        while (validateComputerNumber(randomNumber.toString()));

        // 검증이 끝나면 해당 숫자를 반환
        return randomNumber.toString();
    }

    public boolean validateComputerNumber(String computerNumber) {
        // 각 자리를 비교하기 위한 String 배열
        String[] computerNumberSplit = computerNumber.split("");
        // 조건에 맞지 않으면 예외 발생
        if (computerNumberSplit.length != 3 || Arrays.asList(computerNumberSplit).contains("0") ||
                computerNumberSplit[0].equals(computerNumberSplit[1]) || computerNumberSplit[1].equals(computerNumberSplit[2]) ||
                computerNumberSplit[0].equals(computerNumberSplit[2])) {
            return true;
        } else {
            return false;
        }
    }
}
