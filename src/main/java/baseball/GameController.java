package baseball;

public class GameController {

    private Computer computer;
    private User user;

    public GameController() {
        this.computer = new Computer();
        this.user = new User();
    }

    public void printResult(int ballNum, int strikeNum) {
        if (ballNum != 0) {
            System.out.print(ballNum + "볼 ");
        }
        if (strikeNum != 0) {
            System.out.print(strikeNum + "스트라이크");
        }
        if (strikeNum == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
        if (strikeNum == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }

    }
}
