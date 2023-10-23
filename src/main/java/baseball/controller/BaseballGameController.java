package baseball.controller;

import baseball.model.BaseballGame;
import baseball.model.BaseballNumbers;
import baseball.model.BaseballNumbersGenerator;
import baseball.model.GameRestartString;
import baseball.view.InputView;
import baseball.view.OutputView;

/**
 * 숫자야구 게임을 진행하는 컨트롤러
 */

public class BaseballGameController {

    /**
     * 게임을 시작하고 유저가 게임을 끝내고 싶어할 때까지 게임을 반복하는 메서드
     */

    public static void playGames() {
        OutputView.printGameStart();
        while (true) {
            playGameOnce();
            GameRestartString gameRestartString = InputView.getGameRestartString();
            if (!gameRestartString.doesRestart()) {
                break;
            }
        }
    }

    /**
     * 유저가 입력한 숫자야구 값이 정답을 맞출 때까지 반복하여 입력을 받아 게임을 진행하는 메서드
     */

    private static void playGameOnce() {
        BaseballGame baseballGame = getBaseballGame();
        while (true) {
            OutputView.printBallStrikeResult(baseballGame.getBallCount(), baseballGame.getStrikeCount());
            if (baseballGame.isAnswer()) {
                break;
            }
            BaseballNumbers userBaseballNumbers = BaseballNumbersGenerator.getUserBaseballNumbers(
                    InputView.getStringNumbers());
            baseballGame.resetUserBaseballNumbers(userBaseballNumbers);
        }
    }

    /**
     * 숫자야구 정답지를 생성하고 유저의 숫자야구 값을 입력받아 숫자야구게임 객체를 반환하는 메서드
     *
     * @return 한 번의 숫자야구 게임을 위해 필요한 객체
     */

    private static BaseballGame getBaseballGame() {
        BaseballNumbers computerBaseballNumbers = BaseballNumbersGenerator.getComputerBaseballNumbers();
        BaseballNumbers userBaseballNumbers = BaseballNumbersGenerator.getUserBaseballNumbers(
                InputView.getStringNumbers());
        return new BaseballGame(computerBaseballNumbers, userBaseballNumbers);
    }
}
