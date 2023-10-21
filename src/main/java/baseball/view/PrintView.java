package baseball.view;

public class PrintView {

    public void printGameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printUserInputMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void printScoreMessage(int strike, int ball) {
       if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
       } else if (strike == 0 && ball != 0) {
            System.out.println(ball+"볼");
       } else if (strike != 0 && ball != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
       } else if (strike != 0 && ball ==0) {
            System.out.println(strike+"스트라이크");
        }
    }

    public void printRestartMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
