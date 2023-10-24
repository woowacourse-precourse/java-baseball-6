package baseball.baseball;

import baseball.game.turn.TurnBasedGameView;
import baseball.game.turn.TurnInput;
import baseball.game.turn.TurnResult;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGameConsoleView implements TurnBasedGameView {

    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String REQUEST_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String CLEAR_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    private static final String BALL_UNIT = "볼";
    private static final String STRIKE_UNIT = "스트라이크";
    private static final String NOTHING = "낫싱";

    private static void printNumStrike(int numStrike) {
        System.out.printf("%d%s", numStrike, STRIKE_UNIT);
    }

    private static void printNumBall(int numBall) {
        System.out.printf("%d%s ", numBall, BALL_UNIT);
    }

    private static void printNewLine() {
        System.out.println();
    }

    private static void printNothing() {
        System.out.print(NOTHING);
    }

    @Override
    public void printStart() {
        System.out.println(START_MESSAGE);
    }

    @Override
    public TurnInput requestTurnInput() {
        System.out.print(REQUEST_INPUT_MESSAGE);
        return new BaseballGameTurnInput(Console.readLine());
    }

    @Override
    public void printClear() {
        System.out.println(CLEAR_MESSAGE);
    }

    @Override
    public void printResult(TurnResult turnResult) {
        BaseballGameTurnResult baseballGameTurnResult = (BaseballGameTurnResult) turnResult;

        int numBall = baseballGameTurnResult.getNumBall();
        int numStrike = baseballGameTurnResult.getNumStrike();

        if (numBall == 0 && numStrike == 0) {
            printNothing();
            printNewLine();
            return;
        }

        if (numBall != 0) {
            printNumBall(numBall);
        }

        if (numStrike != 0) {
            printNumStrike(numStrike);
        }

        printNewLine();
    }
}
