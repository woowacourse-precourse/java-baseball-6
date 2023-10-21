package baseball;

public class PrintMessage {

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public void requestNumber() {
        System.out.print("숫자를 입력해주세요 : ");
    }
    /*
     * 힌트 결과 출력
     */
    public void hint(int strike, int ball, boolean nothing) {
        if (nothing == true) {
            System.out.println("낫싱");
            return;
        }
        if (ball != 0) {
            System.out.print(ball + "볼 ");
        }
        if (strike != 0) {
            System.out.print(strike + "스트라이크");
        }
        System.out.println();
    }

    public void gameEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
