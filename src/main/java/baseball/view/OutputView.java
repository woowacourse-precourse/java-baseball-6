package baseball.view;

public class OutputView {
    public void displayGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    // TODO: 더 깔끔한 코드 고민해보기
    public void displayScoreboard(int strike, int ball, int nothing) {
        if(nothing != 0) {
            System.out.println("낫싱");
        }
        else if(strike > 0 && ball > 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
        else if(strike > 0) {
            System.out.println(strike + "스트라이크");
        }
        else {
            System.out.println(ball + "볼");
        }
    }

    public void displayGameExit() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
