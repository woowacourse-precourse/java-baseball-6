package baseball.game;

import baseball.numbers.User;

import java.util.List;

public class UnitOfGame {
    //Computer와 User에 정적 팩토리 메서드 패턴 적용
    private final List<Integer> computerNumbers;

    public UnitOfGame(List<Integer> computerNumbers) {
        this.computerNumbers = computerNumbers;
    }

    public void play() {
        User user = new User();
        List<Integer> userNumbers = user.getUserNumbers();
        int ball = CalculateScore.countBall(computerNumbers, userNumbers);
        int strike = CalculateScore.countStrike(computerNumbers, userNumbers);
        printResult(ball, strike);
        if (strike != 3) {
            play();
        }
    }

    private void printResult(int ball, int strike) {
        if (ball == 0 & strike == 0) {
            System.out.println("낫싱");
        } else if (ball != 0 & strike == 0) {
            System.out.println(ball + "볼");
        } else if (ball == 0 & strike > 0 & strike < 3) {
            System.out.println(strike + "스트라이크");
        } else if (ball != 0 & strike > 0 & strike < 3) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        } else if (strike == 3) {
            System.out.println(strike + "스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }
}
