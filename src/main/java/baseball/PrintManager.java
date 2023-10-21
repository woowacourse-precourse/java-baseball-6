package baseball;

public class PrintManager {

    public void printGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printInputValue() {
        System.out.println("숫자를 입력해주세요.");
    }

    //TODO 리펙토링 고민해보기
    public void printResult(int strike, int ball) {

        if (ball == 0 && strike ==0) {
            System.out.println("낫싱");
        }

        if (ball == 0 && strike != 0) {
            System.out.println(strike + "스트라이크");
        }

        if (ball != 0 && strike == 0) {
            System.out.println(ball + "볼");
        }

        if (ball != 0 && strike != 0)
        System.out.println(ball + "볼 " + strike + "스트라이크");

    }

    public void printGameOver() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

}
