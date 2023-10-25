package baseball;

import baseball.model.Announcer;
import baseball.model.Computer;
import baseball.model.Judge;
import baseball.model.Player;

import java.util.List;


public class Game {
    private final Computer computer;
    private final Player player;
    private final Judge judge;
    private final Announcer announcer;

    public Game(Computer computer, Player player, Judge judge, Announcer announcer) {
        this.computer = computer;
        this.player = player;
        this.judge = judge;
        this.announcer = announcer;
    }

    public void start() {
        announcer.announceStartGame();
        play();
    }

    public void play() {
        List<Integer> answer = computer.speakNumbers();
        playRound(answer);
        end();
    }

    private Result playRound(List<Integer> answer) {
        announcer.announceToSpeakNumber();
        List<Integer> playerNumbers = player.speakNumbers();

        Result result = judge.makeResult(answer, playerNumbers);
        announcer.announceResult(result);

        if (!judge.checkGameOver(result)) playRound(answer);
        return result;
    }

    private void end() {
        announcer.announceGameOver();
    }

    public boolean checkRestart() {
        announcer.announceToSpeakRestart();
        return player.speakRestart();
    }
}
