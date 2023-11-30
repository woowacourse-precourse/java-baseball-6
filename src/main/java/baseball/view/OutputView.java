package baseball.view;

import baseball.domain.Score;

public class OutputView {

    public void printBeforeStart(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printGameResult(int strike, int ball){
        if(strike == 0 && ball == 0){
            System.out.println("낫싱");
            return;

        } if (strike > 0 && ball > 0) {
            System.out.printf("%d볼 %d스트라이크\n", ball, strike);
            return;
        }
        if (strike > 0) {
            System.out.printf("%d스트라이크\n", strike);
            return;
        }
        if (ball > 0) {
            System.out.printf("%d볼\n", ball);
        }

    }
    public void showResult(Score score) {
        printGameResult(score.getStrike(), score.getBall());
    }

}
