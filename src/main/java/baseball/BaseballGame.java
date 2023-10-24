package baseball;

import static baseball.Pitch.MAX_STRIKE;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_MESSAGE = "숫자를 입력하세요 : ";

    private GameOption STATE;

    private RandomNumbers randomNumbers;
    private Pitch pitch;

    public BaseballGame(RandomNumbers randomNumbers) {
        this.randomNumbers = randomNumbers;
        this.pitch = new Pitch(randomNumbers);
        this.STATE = GameOption.PLAY_GAME;
    }

    public void run() {
        System.out.println(START_MESSAGE);

        while (STATE == GameOption.PLAY_GAME) {
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
            STATE = GameOption.valueOfOption(gameOption);
            if (STATE == GameOption.PLAY_GAME) {
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
