package baseball;

import baseball.model.JudgeResult;
import camp.nextstep.edu.missionutils.Console;

public class View {

    private static final String BASEBALL_NUMBER_PROMPT_MSG = "숫자를 입력해주세요 : ";
    private static final String START_PROMPT_MSG = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_OVER_PROMPT_MSG = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_PROMPT_MSG = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String EXIT_PROMPT_MSG = "게임 종료";
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";

    public String getUserNumberInput() {
        System.out.print(BASEBALL_NUMBER_PROMPT_MSG);
        return Console.readLine().strip();
    }

    public void printJudgeResult(JudgeResult judgeResult) {
        StringBuilder judgeResultStringBuilder = new StringBuilder();
        if (judgeResult.getBall() > 0) {
            judgeResultStringBuilder.append(judgeResult.getBall()).append(BALL).append(" ");
        }
        if (judgeResult.getStrike() > 0) {
            judgeResultStringBuilder.append(judgeResult.getStrike()).append(STRIKE);
        }
        if (judgeResult.getBall() == 0 && judgeResult.getStrike() == 0) {
            judgeResultStringBuilder.append(NOTHING);
        }
        System.out.println(judgeResultStringBuilder);
    }

    public void printProgramStart() {
        System.out.println(START_PROMPT_MSG);
    }


    public String getRestartInput() {
        System.out.println(RESTART_PROMPT_MSG);
        return Console.readLine().strip();
    }

    public void printGameOver() {
        System.out.println(GAME_OVER_PROMPT_MSG);
    }

    public void printExitGame() {
        System.out.println(EXIT_PROMPT_MSG);
    }
}
