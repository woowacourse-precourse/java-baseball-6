package baseball;

public class Result {
    private final int GAME_OVER = 3;
    private GameOver gameOver; // 게임 재시작여부 확인 객체

    Result() {
        gameOver = new GameOver();
    }

    public boolean print(int strike, int ball, int nothing) { // 3스트라이크면 true 반환하는 함수
        boolean returnValue = false; // 3스트라이크 판별
        if (ball > 0) {
            printBall(ball);
            if (strike > 0) {
                System.out.println(" ");
            }
        }
        if (strike > 0) {
            returnValue = printStrike(strike);
        }
        if (nothing > 0) {
            printNothing();
        }

        System.out.println();
        return returnValue;
    }

    void printBall(int ball) { // ball을 출력하는 함수
        System.out.print(ball + "볼");
    }

    boolean printStrike(int strike) { // strike를 출력하고 정답이면 게임을 재식할지 묻는 함수
        if (strike == GAME_OVER) {
            gameOver.print();
            return true;
        } else { // 3스트라이크 아니면 출력후 return true
            System.out.print(strike + "스트라이크");
            return false;
        }
    }

    void printNothing() { // 낫싱 출력하는 함수
        System.out.print("낫싱");
    }
}
