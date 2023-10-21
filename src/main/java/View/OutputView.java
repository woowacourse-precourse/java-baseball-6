package View;

import java.util.Map;

public class OutputView {

    private static final OutputView INSTANCE = new OutputView();

    public static OutputView getInstance() {
        return INSTANCE;
    }

    private OutputView() {
    }

    public void printGameStart() {
        System.out.println(Message.GAME_START.getMessage());
    }

    public boolean printGamerResult(Map<String, Integer> comparisonResult) {
        int balls = comparisonResult.get("BALL");
        int strikes = comparisonResult.get("STRIKE");

        if (balls == 0 && strikes == 0) {
            System.out.println(Message.NOTHING.getMessage());
            return false;
        }
        if (balls == 0) {
            System.out.println(strikes + Message.STRIKE.getMessage());

            if (strikes == Message.GAME_END.getEndCount()) {
                return true;
            }

            return false;
        }
        if (strikes == 0) {
            System.out.println(balls + Message.BALL.getMessage());
            return false;
        }
        System.out.println(
                balls + Message.BALL.getMessage() +" " +strikes + Message.STRIKE.getMessage());
        return false;

    }


    private enum Message {
        GAME_START("숫자 야구 게임을 시작합니다"),
        NOTHING("낫싱"),
        BALL("볼"),
        STRIKE("스트라이크"),
        GAME_END(3);

        private String message;
        private int strikeEndCount;

        Message(String message) {
            this.message = message;
        }

        Message(int strikeEndCount) {
            this.strikeEndCount = strikeEndCount;
        }

        public String getMessage() {
            return message;
        }

        public int getEndCount() {
            return strikeEndCount;
        }
    }


}
