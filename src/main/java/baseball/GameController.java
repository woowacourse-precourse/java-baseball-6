package baseball;

import baseball.computer.Answer;
import baseball.computer.Computer;
import baseball.player.Guess;
import baseball.player.Player;
import baseball.player.RestartFlag;

public class GameController {
    private static final boolean ROUND_ONGOING = true;
    private static final boolean ROUND_OVER = false;
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String ANSWER_RESULT = "3스트라이크";
    private static final String ROUND_OVER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String ASK_TO_CONTINUE_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final Player player = new Player();

    public void startGame() {
        System.out.println(GAME_START_MESSAGE);
        boolean continueGame = true;
        while (continueGame) {
            Computer computer = new Computer();
            startRound(computer);
            System.out.println(ASK_TO_CONTINUE_MESSAGE);
            RestartFlag restartFlag = player.makeRestartFlag();
            continueGame = restartFlag.toBoolean();
        }
    }

    private void startRound(Computer computer) {
        boolean isRoundOngoing = ROUND_ONGOING;
        while (isRoundOngoing) {
            Answer answer = computer.generateAnswer();
            isRoundOngoing = decideRoundOngoing(submitGuessAndGetResult(computer));
        }
        System.out.println(ROUND_OVER_MESSAGE);
    }

    private String submitGuessAndGetResult(Computer computer) {
        System.out.println(INPUT_NUMBER_MESSAGE);
        Guess playerGuess = player.makeGuess();
        String queryResult = computer.generateResult(playerGuess);
        System.out.println(queryResult);
        return queryResult;
    }

    private boolean decideRoundOngoing(String queryResult) {
        if (queryResult.equals(ANSWER_RESULT)) {
            return ROUND_OVER;
        }
        return ROUND_ONGOING;
    }
}
