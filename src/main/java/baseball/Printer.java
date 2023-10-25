package baseball;

import java.io.Console;

public class Printer {

    public void startMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void inputMessage() {
        System.out.print("숫자를 입력해 주세요 : " );
    }

    public void endMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void restartMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void onlyBallMessage(int ball) {
        System.out.println(ball+"볼");
    }

    public void nothingMessage(){
        System.out.println("낫싱");
    }

    public void onlyStrikeMessage(int strike){
        System.out.println(strike+"스트라이크");
    }

    public void ballStirkeMessage(int ball, int strike){
        System.out.println(ball+"볼 "+strike+"스트라이크");
    }
}
