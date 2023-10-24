package baseball.view;

import baseball.dto.ScoreDto;

public class OutputView {

    public static void start() {

        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void exit() {

        System.out.println("게임을 종료합니다.");
    }

    public static void printScore(ScoreDto scoreDto) {

        int strike = scoreDto.getStrike();
        int ball = scoreDto.getBall();

        if(strike == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return;
        }

        if(strike > 0 && ball > 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
            return;
        }

        if(strike > 0) {
            System.out.println(strike + "스트라이크");
            return;
        }

        if(ball > 0) {
            System.out.println(ball + "볼 ");
            return;
        }

        System.out.println("낫싱");
    }
}
