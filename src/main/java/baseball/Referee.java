package baseball;

public class Referee {
    private int strike;
    private int ball;
    public Referee() {
        strike = 0;
        ball = 0;
    }
    public void compareNumbers(Player player1, Player player2) {
        int strike = 0, ball = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (player1.getNumber(i) == player2.getNumber(j)) {
                    if (i == j)
                        strike++;
                    else
                        ball++;
                }
            }
        }

        this.strike = strike;
        this.ball = ball;
    }
    public void printScore() {
        if (ball > 0)
            System.out.print(ball + "볼 ");
        if (strike > 0)
            System.out.print(strike + "스트라이크");
        if (ball + strike == 0)
            System.out.print("낫싱");
        System.out.println();
    }
    public boolean checkComplete() {
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }
}
