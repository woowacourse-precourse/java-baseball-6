package baseball;

class Hint {
    int ball, strike;

    private static final String BALL_WORD = "볼";
    private static final String STRIKE_WORD = "스트라이크";
    private static final String NOT_MATCH_WORD = "낫싱";

    public String toString() {
        return "ball: " + this.ball + ", strike: " + this.strike;
    }

    private void addBallCount() {
        this.ball++;
    }

    private void addStrikeCount() {
        this.strike++;
    }

    void compareAnswer(Game answer, Game rightAnswer) {
        int nowNumber;

        for (int i = 0; i < Game.NUMBER_COUNT; i++) {
            nowNumber = answer.number[i];

            if (!Array.checkArrayContains(rightAnswer.number, nowNumber)) {
                continue;
            }
            if (i == Array.getIndexFromValue(rightAnswer.number, nowNumber)) {
                addStrikeCount();
                continue;
            }

            addBallCount();
        }
    }

    void showResult() {
        String result = "";
        if (this.ball != 0) {
            result += this.ball + BALL_WORD;
        }

        if (this.strike != 0) {
            if (this.ball != 0) {
                result += " ";
            }
            result += this.strike + STRIKE_WORD;
        }

        if (result.equals("")) {
            result = NOT_MATCH_WORD;
        }

        System.out.println(result);
    }
}

