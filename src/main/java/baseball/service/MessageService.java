package baseball.service;

import java.util.ArrayList;

public class MessageService {

    public void startMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void inputMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void endMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void restartMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void resultMessage(ArrayList<Integer> ballCount) {
        String result = "";
        int ball = ballCount.get(0);
        int strike = ballCount.get(1);

        if (strike > 0 && ball > 0)
            result += ball + "볼 " + strike + "스트라이크";
        else if (ball > 0)
            result = ball + "볼";
        else if (strike > 0)
            result = strike + "스트라이크";
        else
            result = "낫싱";

        System.out.println(result);
    }

}
