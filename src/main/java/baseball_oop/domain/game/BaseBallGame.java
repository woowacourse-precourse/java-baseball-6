package baseball_oop.domain.game;

import baseball_oop.enums.ReplyOrNot;
import baseball_oop.vo.Answer;
import baseball_oop.domain.participant.computer.Computer;
import baseball_oop.domain.participant.judgment.Judgment;
import baseball_oop.domain.participant.player.Player;
import baseball_oop.vo.Result;

import static camp.nextstep.edu.missionutils.Console.readLine;

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
        String command;
        do {
            play();
            command = readLine();

        } while (ReplyOrNot.REPLY.getCode().equals(command));
    }

    private void play() {
        Answer answer = computer.generateAnswer();
        Answer input;
        Result result = null;
        while (!result.isWin()) {
            input = player.generateAnswer();
            result = judgment.judge(answer, input);
        }
    }
}
