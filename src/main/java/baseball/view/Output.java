package baseball.view;

import java.util.List;

public class Output {

    public static void PrintInitialMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void PrintResultMessage(int ball, int strike) {

        if(ball==0 && strike==0) {
            System.out.println("낫싱");
        } else if (ball==0 && strike!=0) {
            System.out.println(strike+"스트라이크");
        } else if (ball!=0 && strike==0) {
            System.out.println(ball+"볼");
        } else {
            System.out.println(ball+"볼 "+strike+"스트라이크");
        }
    }

    public static void PrintExitMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

}
