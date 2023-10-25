package baseball.view;

import baseball.game.StrikeBall;

public class OutputView {
    private static final String BASEBALL_GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String BASEBALL_GAME_USER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String BASEBALL_GAME_THREE_STRIKE_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료.";
    private static final String BASEBALL_GAME_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String BASEBALL_GAME_RESULT_NOTING = "낫싱";
    private static final String BASEBALL_GAME_RESULT_BALL = "볼 ";
    private static final String BASEBALL_GAME_RESULT_STRIKE = "스트라이크 ";


    public void print(String T) {
        System.out.printf("%s", T);
    }

    public void println(String T) {
        System.out.println(T);
    }

    public void printBaseballGameStart() {
        println(BASEBALL_GAME_START_MESSAGE);
    }

    public void printUserNumberInput() {
        print(BASEBALL_GAME_USER_INPUT_MESSAGE);
    }

    public void printStrikeBallResult(StrikeBall strikeBall) {
        StringBuilder sb = new StringBuilder();

        if(strikeBall.isNoting()) {
            sb.append(BASEBALL_GAME_RESULT_NOTING);
        }

        if(strikeBall.hasBallCount()) {
            sb.append(strikeBall.getBall()).append(BASEBALL_GAME_RESULT_BALL);
        }

        if(strikeBall.hasStrikeCount()) {
            sb.append(strikeBall.getStrike()).append(BASEBALL_GAME_RESULT_STRIKE);
        }

        println(sb.toString());
    }

    public void printThreeStrikeSuccess() { println(BASEBALL_GAME_THREE_STRIKE_MESSAGE); }

    public void printBaseballGameRestart() {
        println(BASEBALL_GAME_RESTART_MESSAGE);
    }
}