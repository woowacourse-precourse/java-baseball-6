package baseball;

public class Outputs {
    public void wordStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void wordInsertNumber() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void wordStrike() {
        System.out.print("스트라이크 ");
    }

    public void wordBall() {
        System.out.print("볼 ");
    }

    public void wordNothing() {
        System.out.println("낫싱");
    }

    public void wordWinTheGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }


}
