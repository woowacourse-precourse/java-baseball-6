package baseball;

class ShowResult {
    private final int numberOfDigits;
    private static final String NO_HITS_MESSAGE = "낫싱";
    private static final String BALL_MESSAGE = "%d볼 ";
    private static final String STRIKE_MESSAGE = "%d스트라이크";
    private static final String WIN_MESSAGE = "%d개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public ShowResult(int numberOfDigits) {
        this.numberOfDigits = numberOfDigits;
    }

    // 볼, 스트라이크 계산 후 결과 출력
    public void displayResult(int strike, int ball) {
        if (isNoHits(strike, ball)) {
            System.out.println(NO_HITS_MESSAGE);
            return;
        }
        displayBallCount(ball);
        displayStrikeCount(strike);
        System.out.println();
        if (isWinning(strike)){
            displayWinningMessage(strike);
        }
    }

    private boolean isNoHits(int strike, int ball) {
        return strike == 0 && ball == 0;
    }

    private boolean isWinning(int strike) {
        return strike == numberOfDigits;
    }

    private void displayBallCount(int ball) {
        if (ball > 0) {
            System.out.printf(BALL_MESSAGE, ball);
        }
    }

    private void displayStrikeCount(int strike) {
        if (strike > 0) {
            System.out.printf(STRIKE_MESSAGE, strike);
        }
    }

    public void displayWinningMessage(int strike) {
        System.out.printf(WIN_MESSAGE + "%n", numberOfDigits); // all strike인 경우 게임 종료 문구 출력
    }
}
