package baseball;

public class Result {
    public void printResult(int strike,int ball) {
        if (strike == 0 && ball == 0) {
            printNothing();
            return;
        }
        if (strike == 3) {
            printEnd();
            return;
        }
        printBall(ball);
        printStrike(strike);
    }
    public void printBall(int ball) {
        if(ball != 0) {
            System.out.print(ball + "볼 ");
        }
    }
    public void printStrike(int strike) {
        if(strike == 0) {
            System.out.println("");
            return;
        }
        System.out.println(strike + "스트라이크");
    }
    public void printNothing() {
        System.out.println("낫싱");
    }
    public void printEnd() {
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
