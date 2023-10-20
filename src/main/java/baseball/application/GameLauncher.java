package baseball.application;

import baseball.domain.Computer;
import baseball.domain.Pitch;
import baseball.domain.Judgement;
import baseball.util.channel.Printer;
import baseball.util.channel.Reader;
import baseball.util.JudgementConverter;
import baseball.util.enums.Command;

import java.util.Arrays;
import java.util.List;

public class GameLauncher {

    private final Computer computer;

    public GameLauncher(Computer computer) {
        this.computer = computer;
    }
    public void execute() {
        boolean finishFlag;
        do {
            Pitch pitch = createPitch(Reader.read(Command.PITCHING));
            Judgement judgement = judge(pitch);

            Printer.println(JudgementConverter.of(judgement));
            finishFlag = judgement.isThreeStrike();
        } while (!finishFlag);
        Printer.print(Command.END_GAME.getCommand());
    }
    private Pitch createPitch(String input) {
        List<Integer> pitches = Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .toList();
        return new Pitch(pitches);
    }

    private Judgement judge(Pitch player) {
        return new Judgement(
                computer.countBall(player.getPitches()),
                computer.countStrike(player.getPitches())
        );
    }

}
