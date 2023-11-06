package baseball_oop.domain.game;

import baseball_oop.vo.Answer;
import baseball_oop.domain.participant.computer.Computer;
import baseball_oop.domain.participant.judgment.Judgment;
import baseball_oop.domain.participant.player.Player;
import baseball_oop.vo.Result;

public class BaseBallGame implements Game {
    private final Computer computer;
    private final Judgment judgment;
    private final Player player;

    public BaseBallGame(Computer computer, Player player, Judgment judgment) {
        this.computer = computer;
        this.judgment = judgment;
        this.player = player;
    }
    @Override
    public void start() {
        do {
            play();
        } while (true);
    }

    private void play() {
        Answer answer = computer.generateAnswer();
        Answer input = player.generateAnswer();
        Result result = judgment.judge(answer, input);
    }
}
