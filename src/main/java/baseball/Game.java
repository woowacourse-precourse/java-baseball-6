package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {

    private Balls computerBalls;
    private boolean isGameOver = false;

    public Game(Balls computerBalls) {
        this.computerBalls = computerBalls;
    }

    private void computerBallReset() {
        computerBalls = new Balls();
    }


    private void gameOver() {
        GameIO.gameRestartPrint();
        String command = Console.readLine();
        if (command.equals("2")) {
            isGameOver = true;
            return;
        }
        computerBallReset();
    }

    public void play() {
        while (!isGameOver) {
            Balls playerBalls = new Balls(Console.readLine());
            boolean isMatching = computerBalls.match(playerBalls);

            if (isMatching) {
                gameOver();
            }
        }
    }
}
