package baseball;

import java.util.List;

import static baseball.Printer.printInputNumberComment;

public class Game {
    private final Computer computer;
    private final Player player;
    private final Judge judge;
    private boolean isOver = false;

    public Game(Computer computer, Player player, Judge judge) {
        this.computer = computer;
        this.player = player;
        this.judge = judge;
    }

    public void start() {
        judge.announceStartGame();
        play();
    }

    public void play() {
        List<Integer> answer = computer.speakNumbers();

        while (!isOver) {
            Result result = playRound(answer);
            judge.announceResult(result);
            isOver = judge.checkGameOver(result);
        }

        end();
    }

    private Result playRound(List<Integer> answer) {
        printInputNumberComment();
        List<Integer> playerNumbers = player.speakNumbers();

        return judge.makeResult(answer, playerNumbers);
    }

    private void end() {
        judge.announceGameOver();
    }
}
