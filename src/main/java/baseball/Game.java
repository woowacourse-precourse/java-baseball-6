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
        Command command = Command.findByCommand(Console.readLine());
        if (command.isEnd()) {
            isGameOver = true;
            return;
        }
        computerBallReset();
    }

    public void play() {
        GameIO.gameStartPrint();
        while (!isGameOver) {
            GameIO.gameInputPrint();
            Balls playerBalls = new Balls(Console.readLine());
            boolean isMatching = computerBalls.match(playerBalls);

            if (isMatching) {
                gameOver();
            }
        }
    }
}
