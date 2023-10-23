package baseball;

public class GameView {

    public GameView() {
    }

    public void printMessage(String Message) {
        System.out.println(Message);
    }

    public void showResult(int strike, int ball) {
        if(strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (strike == 0 && ball != 0) {
            System.out.println(ball + "볼");
        } else if (strike != 0 && ball == 0) {
            System.out.println(strike + "스트라이크");
        } else if (strike != 0 && ball != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        } else if (strike == 3 && ball == 0) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

        }
    }

}
