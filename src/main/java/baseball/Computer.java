package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.lang.reflect.Array;
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

    public void checkNumber(String computerNumber, String playerNumber) {
        String[] computerNumberSplit = computerNumber.split("");
        String[] playerNumberSplit = playerNumber.split("");
        String hint = "";

        for (int i = 0; i < 3; i++) {
            // 볼이 있는지 검사
            // 만약 플레이어가 입력한 숫자 중 i번째가 컴퓨터가 가지고 있는 숫자에 포함되면 볼 횟수 증가
            if (Arrays.asList(computerNumberSplit).contains(playerNumberSplit[i])) {
                stateBall += 1;
            } else {
                stateNothing += 1;
            }

            // 스트라이크가 있는지 검사
            // 스트라이크가 존재하면 볼 횟수 감소, 스트라이크 횟수 증가
            if (computerNumberSplit[i].equals(playerNumberSplit[i])) {
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
