package baseball.application;

import baseball.domain.Computer;
import baseball.domain.Pitch;
import baseball.domain.Judgement;
import baseball.util.channel.Printer;
import baseball.util.channel.GameReader;
import baseball.util.JudgementConverter;
import baseball.util.enums.Command;

import java.util.Arrays;
import java.util.List;

public class GameLauncher {

    private final Computer computer;

    public GameLauncher(Computer computer) {
        this.computer = computer;
    }

    /**
     * 한 게임을 실행하는 유일한 public 메서드
     * @see baseball.Application
     */
    public void execute() {
        boolean finishFlag;
        do {
            Pitch pitch = createPitch(GameReader.read(Command.PITCHING));
            Judgement judgement = judge(pitch);

            Printer.println(JudgementConverter.of(judgement));
            finishFlag = judgement.isThreeStrike();
        } while (!finishFlag);
        Printer.print(Command.END_GAME.getCommand());
    }

    /**
     * 입력값을 한 글자씩 분할하여 Pitch 객체로 변환하는 메서드
     *
     * @param input 사용자의 입력값
     * @return 입력값에 대한 Pitch 변환 객체
     * @see Pitch
     */
    private Pitch createPitch(String input) {
        List<Integer> pitches = Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .toList();
        return new Pitch(pitches);
    }

    /**
     * Pitch 에 대해 본 게임의 Computer 와 비교하여 구종을 판별하는 메서드
     * @param pitch 사용자가 입력한 구종
     * @return 판정 결과
     * @see Judgement
     */
    private Judgement judge(Pitch pitch) {
        return new Judgement(
                computer.countBall(pitch.getPitches()),
                computer.countStrike(pitch.getPitches())
        );
    }

}
