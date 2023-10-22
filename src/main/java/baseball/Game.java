package baseball;

import java.util.List;

import static baseball.Printer.*;

public class Game {
    private final Computer computer;
    private final Player player;
    private final Judge judge;
    private boolean isFinish = false;

    public Game(Computer computer, Player player, Judge judge) {
        this.computer = computer;
        this.player = player;
        this.judge = judge;
    }

    public void start() {
        printStartGameComment();
        play();
    }

    public void play() {
        while (true) {
            playOneRound();
            if (isFinish) break;
        }
    }

    private void playOneRound() {
        printInputNumberComment();
        List<Integer> answer = computer.loadRandomNumberList();
        List<Integer> playerNumbers = player.load3NumberList();

        Result result = judge.calculateResult(answer, playerNumbers);
        isFinish = judge.checkGameIsFinish(result);
        judge.announceResult(result);
    }

    public boolean isFinish() {
        printEndGameComment();
        printRestartGameComment();

        return player.chooseFinishGame();
    }
}
