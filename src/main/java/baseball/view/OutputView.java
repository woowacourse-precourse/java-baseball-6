package baseball.view;

import baseball.model.Hint;

public class OutputView {
    private static final String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String END_GAME_MESSAGE = "게임 종료";
    private static final String SUCCESS_MESSAGE = "3개의 숫자를 모두 맞히셨습니다!";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String BALL_MESSAGE = "볼";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String SPACE = " ";

    public static void printStartGameMessage() {
        System.out.println(START_GAME_MESSAGE);
    }
    public static void printEndGameMessage() {
        System.out.print(END_GAME_MESSAGE);
    }

    public static void printSuccessMessage() {
        System.out.println(SUCCESS_MESSAGE);
    }

    public static void printHintMessage(Hint hint) {
        if(hint.getBallCount() == 0 && hint.getStrikeCount() == 0) {
            printNothingMessage();
        }
        else if(hint.getBallCount() == 0) {
            printStrikeMessage(hint.getStrikeCount());
        }
        else if(hint.getStrikeCount() == 0) {
            printBallMessage(hint.getBallCount());
        }
        else {
            printBallStrikeMessage(hint.getBallCount(), hint.getStrikeCount());
        }
    }

    public static void printNothingMessage() {
        System.out.println(NOTHING_MESSAGE);
    }
    public static void printBallMessage(Integer ballCount) {
        System.out.println(ballCount.toString() + BALL_MESSAGE);
    }

    public static void printStrikeMessage(Integer strikeCount) {
        System.out.println(strikeCount.toString() + STRIKE_MESSAGE);
    }

    public static void printBallStrikeMessage(Integer ballCount, Integer strikeCount) {
        String Message = ballCount.toString() + BALL_MESSAGE +
                SPACE +
                strikeCount.toString() + STRIKE_MESSAGE;
        System.out.println(Message);
    }
}
