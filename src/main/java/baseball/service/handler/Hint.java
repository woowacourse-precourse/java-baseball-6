package baseball.service.handler;

public class Hint {
    private static final String BALL_WORD = "볼";
    private static final String STRIKE_WORD = "스트라이크";
    private static final String NOT_THING_WORD = "낫싱";
    private Integer ball = 0, strike = 0;

    private void addStrikeCount() {
        this.strike++;
    }

    private void addBallCount() {
        this.ball++;
    }

    /**
     * Hint reset
     */
    public void resetHint() {
        this.ball = 0;
        this.strike = 0;
    }

    public int getStrike() {
        return strike;
    }

    /**
     * Show hint
     */
    public void showHint(String player_number, String computer_number) {

        compareAnswer(player_number, computer_number);
        StringBuilder result = new StringBuilder();

        if (ball != 0) {
            result.append(ball).append(BALL_WORD);
        }
        if (strike != 0 && !result.isEmpty()) {
            result.append(" ");
        }
        if (strike != 0) {
            result.append(strike).append(STRIKE_WORD);
        }
        if (result.isEmpty()) {
            result.append(NOT_THING_WORD);
        }

        System.out.println(result);
    }

    /**
     * compare player_number and computer_number
     *
     * @param player_number   : 플레이어가 입력한 수
     * @param computer_number : 컴퓨터가 랜덤으로 얻은 수
     */
    private void compareAnswer(String player_number, String computer_number) {
        int length = player_number.length();
        //입력한 수의 자리수 만큼 반복
        for (int i = 0; i < length; i++) {
            char player_num = player_number.charAt(i);  //i번쨰 자리수의 수
            //player의 i번쨰 자리수의 숫자가 컴퓨터의 수에 포함되어 있지 않으면 pass
            if (!computer_number.contains(String.valueOf(player_num))) {
                continue;
            }
            // 스트라이크 일경우
            if (computer_number.charAt(i) == player_num) {
                addStrikeCount();
                continue;
            }
            addBallCount(); //그 외는 ball
        }
    }


}
