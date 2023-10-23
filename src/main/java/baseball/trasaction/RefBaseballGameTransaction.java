package baseball.trasaction;

import baseball.io.Input;
import baseball.io.Output;
import baseball.object.generic.BallCount;
import baseball.object.number.BaseballNumbers;
import baseball.object.number.WinningNumbers;
import baseball.object.number.generator.BaseballNumbersGenerator;
import baseball.object.number.generator.WinningNumbersGenerator;
import java.util.Objects;
import java.util.Set;

public class RefBaseballGameTransaction {

    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String MUST_INPUT_RESTARTS_MESSAGE = "1 또는 2를 입력해야 합니다.";

    private static final String GAME_RESTART = "1";
    private static final String GAME_FINISH = "2";
    private static final Set<String> INPUT_RESTARTS = Set.of(GAME_RESTART, GAME_FINISH);

    public void run() {
        try {

            Output.consoleLine(GAME_START_MESSAGE);

            boolean whetherPlay = true;
            while (whetherPlay) {

                WinningNumbers winningNumbers = new WinningNumbers(new WinningNumbersGenerator());
                while (true) {
                    BaseballNumbers baseballNumbers = new BaseballNumbers(new BaseballNumbersGenerator());
                    BallCount ballCount = winningNumbers.ballCounting(baseballNumbers);
                    Output.consoleLine(ballCount);
                    if (ballCount.isFullCount()) break;
                }
                Output.consoleLine("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

                Output.consoleLine(GAME_RESTART_MESSAGE);
                String inputRestart = Input.consoleLine();

                if (!INPUT_RESTARTS.contains(inputRestart)) {
                    throw new IllegalArgumentException(MUST_INPUT_RESTARTS_MESSAGE);
                }

                if (Objects.equals(inputRestart, GAME_FINISH)) {
                    whetherPlay = false;
                }
            }

        } catch (IllegalArgumentException e) {
            Output.consoleLine("예외가 발생하여 어플리케이션을 종료합니다.");
            throw e;
        }
    }

}