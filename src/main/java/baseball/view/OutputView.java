package baseball.view;

import baseball.model.Count;
public class OutputView {
    public void printStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printResult(Count count) {
        int strike = count.getStrike();
        int ball = count.getBall();

        if (strike == 3){
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }

        else if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        }

        else{
            System.out.println(ball+"볼 " + strike + "스트라이크");
        }
    }
}
