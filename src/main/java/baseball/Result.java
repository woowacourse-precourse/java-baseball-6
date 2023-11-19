package baseball;

public class Result {

    public void printBallAndStrike(int ball, int strike) {
        if (ball != 0 && strike != 0) {
            System.out.printf("%d볼 %d스트라이크", ball, strike);
        }
        if (ball != 0 && strike == 0) {
            System.out.printf("%d볼", ball);
        }
        if (ball == 0 && strike != 0) {
            System.out.printf("%d스트라이크", strike);
        }
        if (ball == 0 && strike == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
    }
}
