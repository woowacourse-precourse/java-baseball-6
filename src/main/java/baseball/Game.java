package baseball;

import java.util.List;

import static baseball.Printer.*;

public class Game {
    private final Computer computer;
    private final Player player;
    private final Judge judge;
    private boolean isEnd = false;
    private boolean isRestart = false;

    public Game(Computer computer, Player player, Judge judge) {
        this.computer = computer;
        this.player = player;
        this.judge = judge;
    }

    public void start() {
        judge.announceStartGame();
        playGame();
    }

    // TODO: 적절한 이름이 무엇일지 고민
    //  -> playGame(): 클래스명과 중복, play(): playOneRound 와 혼동 가능성
    public void playGame() {
        while (true) {
            playOneRound();
            if (isEnd) break;
        }

        end();
    }

    private void playOneRound() {
        printInputNumberComment();
        List<Integer> answer = computer.loadRandomNumberList();
        List<Integer> playerNumbers = player.load3NumberList();

        Result result = judge.makeResult(answer, playerNumbers);
        isEnd = judge.checkGameIsFinish(result);
        judge.announceResult(result);
    }

    public void end() {
        judge.announceEndGame();
        isRestart = judge.checkPlayerWantRestart(player);
    }

    public boolean isRestart() {
        return isRestart;
    }
}
