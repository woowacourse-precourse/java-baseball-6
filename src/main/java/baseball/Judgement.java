package baseball;

public enum Judgement {
    BALL("볼"), STRIKE("스트라이크"), NOTHING("낫싱");

    private String symbol;
    private int count;


    Judgement(String symbol) {
        this.symbol = symbol;
    }

    public void countSymbol() {
        count++;
    }

    public static void initCount() {
        BALL.count = 0;
        STRIKE.count = 0;
        NOTHING.count = 0;
    }

    public static boolean isWin() {
        return STRIKE.count == 3;
    }

    public static String judgeState() {
        String state = judgeBall() + " " + judgeStrike();
        if (state.equals(" ")) {
            state = NOTHING.symbol;
        }
        return state.trim();
    }

    private static String judgeBall() {
        if (Judgement.BALL.count > 0) {
            return Judgement.BALL.count + "볼";
        }
        return "";
    }

    private static String judgeStrike() {
        if (Judgement.STRIKE.count > 0) {
            return Judgement.STRIKE.count + "스트라이크";
        }
        return "";
    }
}
