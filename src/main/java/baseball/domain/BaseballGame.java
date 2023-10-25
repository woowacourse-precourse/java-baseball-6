package baseball.domain;

import static baseball.domain.Pitch.MAX_STRIKE;

import baseball.domain.utils.GameOption;
import baseball.domain.utils.InputRange;
import baseball.utils.RandomNumbers;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_MESSAGE = "숫자를 입력하세요 : ";

    private GameOption state;

    private RandomNumbers randomNumbers;
    private Pitch pitch;

    public BaseballGame(RandomNumbers randomNumbers) {
        this.randomNumbers = randomNumbers;
        this.pitch = new Pitch(randomNumbers);
        this.state = GameOption.PLAY_GAME;
    }

    public void run() {
        System.out.println(START_MESSAGE);

        while (state == GameOption.PLAY_GAME) {
            String inputNumbers = getInputNumbers();
            pitch.judgePitch(inputNumbers);
            pitch.printPitchResult();
            checkRestartGame(randomNumbers, pitch);
            pitch.pitchClear();
        }

    }

    private void checkRestartGame(RandomNumbers randomNumbers, Pitch pitch) {
        if (pitch.getStrike() == MAX_STRIKE) {
            int gameOption = Integer.parseInt(Console.readLine());
            state = GameOption.valueOfOption(gameOption);
            if (state == GameOption.PLAY_GAME) {
                randomNumbers.randomNumbersGenerate();
            }
        }
    }

    private String getInputNumbers() {
        System.out.printf(INPUT_MESSAGE);
        String inputNumbers = Console.readLine();
        InputRange.validate(inputNumbers);
        return inputNumbers;
    }
}
