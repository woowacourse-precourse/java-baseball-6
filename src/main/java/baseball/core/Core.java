package baseball.core;

import java.util.List;

// 스트라이크 판정 - 컴퓨터 넘버와 유저 넘버 인덱스 비교 후 스트라이크 판단 boolean으로 True Flase 판정
public class Core {
    public boolean isDigitStrike(List<Integer> computerNumber, List<Integer> userNumber, int index) {
        return computerNumber.get(index).equals(userNumber.get(index));
    }

    // 스트라이크 개수 카운트 - 컴퓨터넘버와 유저넘버 비교
    public int countStrike(List<Integer> computerNumber, List<Integer> userNumber) {
        int count = 0;
        for (int index = 0; index < userNumber.size(); index++) {
            if (isDigitStrike(computerNumber, userNumber, index)) {
                count++;
            }
        }
        return count;
    }

    // 볼 판정 - 컴퓨터 넘버와 유저 넘버 인덱스 비교 후 불 판단 boolean으로 True Flase 판정
    public boolean isDigitBall(List<Integer> computerNumber, List<Integer> userNumber, int index) {
        if (isDigitStrike(computerNumber, userNumber, index)) {
            return false;
        }
        for (int cur = 0; cur < computerNumber.size(); cur++) {
            if (index == cur) {
                continue;
            }
            if (userNumber.get(index) == computerNumber.get(cur)) {
                return true;
            }
        }
        return false;
    }

    // 볼 카운트 개수 - 컴퓨터넘버와 유저넘버 비교
    public int countBall(List<Integer> computerNumber, List<Integer> userNumber) {
        int count = 0;
        for (int index = 0; index < userNumber.size(); index++) {
            if (isDigitBall(computerNumber, userNumber, index)) {
                count++;
            }
        }
        return count;
    }

    // 게임 결과 값 출력부분
    public void printGameResult(int strikes, int balls) {
        if (strikes == 0 && balls == 0) {
            System.out.println("낫싱");
            return;
        }   // 스트라이크 & 볼이 0이면 낫싱출력
        if (strikes > 0 && balls > 0) {
            System.out.printf("%d볼 %d스트라이크\n", balls, strikes);
            return;
        }   // 스트라이크와 볼이 둘다 있으면
        if (strikes > 0) {
            System.out.printf("%d스트라이크\n", strikes);
            return;
        }   // 스트라이크가 있으면
        if (balls > 0) {
            System.out.printf("%d볼\n", balls);
        }   // 볼이 있으면
    }
}