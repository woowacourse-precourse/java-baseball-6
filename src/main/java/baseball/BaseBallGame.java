package baseball;

import camp.nextstep.edu.missionutils.*;

public class BaseBallGame {
    private boolean gameOver = false;
    private BaseBall answer;

    public BaseBallGame(final BaseBall answer) {
        this.answer = answer;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void start() {
        System.out.print("숫자를 입력해주세요: ");
        BaseBall input = new BaseBall(Console.readLine());
        int strikes = answer.countStrikes(input);
        if (strikes == 3) {
            gameOver = true;
        } else {
            if (answer.isNothing(input)) {
                System.out.print("낫싱 ");
            }
            int balls = answer.countBalls(input);
            if (balls > 0) {
                System.out.printf("%d볼 ", balls);
            }
            if (strikes > 0) {
                System.out.printf("%d스트라이크 ", strikes);
            }
            System.out.println("\b");
        }
    }
}
