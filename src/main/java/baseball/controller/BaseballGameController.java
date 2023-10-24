package baseball.controller;

import baseball.model.BaseballGame;
import baseball.model.BaseballNumbers;
import baseball.model.BaseballNumbersGenerator;
import baseball.model.GameRestartString;
import baseball.view.InputView;
import baseball.view.OutputView;

/**
 * 숫자야구 게임을 규칙에 맞게 진행하는 클래스입니다.
 */

public class BaseballGameController {

    /**
     * 유저가 정답을 맞추고 게임을 종료 신호를 보낼 때까지 게임을 반복합니다.
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
     * 첫 라운드를 시작 후 유저가 정답을 맞출 때까지 라운드를 반복합니다.
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
     * 숫자야구 답안을 만들고 유저의 숫자야구 값을 입력받아 첫 라운드를 수행하기 위한 객체를 반환합니다.
     *
     * @return 숫자야구 게임의 라운드를 관리하는 객체
     */

    private static BaseballGame getBaseballGame() {
        BaseballNumbers computerBaseballNumbers = BaseballNumbersGenerator.getComputerBaseballNumbers();
        BaseballNumbers userBaseballNumbers = BaseballNumbersGenerator.getUserBaseballNumbers(
                InputView.getStringNumbers());
        return new BaseballGame(computerBaseballNumbers, userBaseballNumbers);
    }
}
