package baseball.view;

public class Output {

    public void printBall() {
        System.out.println("볼");
    }

    public void printStrike() {
        System.out.println("스트라이크");
    }

    public void printBallAndStrike() {
        System.out.print("볼 ");
    }

    public void printCount(int count) {
        System.out.print(count);
    }

    public void printNothing() {
        System.out.println("낫싱");
    }

    public void printEndGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

}
