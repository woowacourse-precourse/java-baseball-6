package View;

import java.util.Map;

public class OutputView {

    private static final OutputView INSTANCE = new OutputView();

    private static final String BALL = "BALL";
    private static final String STRIKE = "STRIKE";

    public static OutputView getInstance() {
        return INSTANCE;
    }

    private OutputView() {
    }

    public void printGameStart() {
        printMessage(Message.GAME_START);
    }

    public boolean printGamerResult(Map<String, Integer> comparisonResult) {
        int balls = comparisonResult.getOrDefault(BALL, Message.ZERO.getCount());
        int strikes = comparisonResult.getOrDefault(STRIKE, Message.ZERO.getCount());

        if (isNoHit(balls, strikes)) {
            printMessage(Message.NOTHING);
            return false;
        }

        return printHits(balls, strikes);
    }


    private boolean isNoHit(int balls, int strikes) {
        return balls == Message.ZERO.getCount() && strikes == Message.ZERO.getCount();
    }

    private boolean printHits(int balls, int strikes) {

        if (balls != Message.ZERO.getCount()) {
            printBallMessage(balls);
        }

        if (strikes != Message.ZERO.getCount()) {
            printStrikeMessage(strikes);
        }

        System.out.println();

        return isGameEnd(strikes);
    }

    private void printBallMessage(int balls) {
        System.out.print(balls + Message.BALL.getMessage() + " ");
    }

    private void printStrikeMessage(int strikes) {
        System.out.print(strikes + Message.STRIKE.getMessage());
    }

    private boolean isGameEnd(int strikes) {
        return strikes == Message.GAME_END.getCount();

    }

    private void printMessage(Message message) {
        System.out.println(message.getMessage());
    }


    private enum Message {
        GAME_START("게임을 시작합니다."), NOTHING("낫싱"), BALL("볼"), STRIKE("스트라이크"), GAME_END(3), ZERO(0);

        private String message;
        private int count;

        Message(String message) {
            this.message = message;
        }

        Message(int count) {
            this.count = count;
        }

        public String getMessage() {
            return message;
        }

        public int getCount() {
            return count;
        }

    }
}
