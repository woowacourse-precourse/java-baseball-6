package baseball.service.handler;

public class Hint {
    private static final String BALL_WORD = "볼";
    private static final String STRIKE_WORD = "스트라이크";
    private static final String NOT_THING_WORD = "낫싱";
    private Integer ball_count = 0, strike_count = 0;   //볼과 스트라이크 수

    /**
     * strike_count를 1만큼 증가
     */
    private void increaseStrikeCount() {
        this.strike_count++;
    }

    /**
     * ball_count를 1만큼 증가
     */
    private void increaseBallCount() {
        this.ball_count++;
    }

    /**
     * Hint reset
     */
    public void resetHint() {
        this.ball_count = 0;
        this.strike_count = 0;
    }

    /**
     * strike_count getter
     *
     * @return strike_count
     */
    public int getStrike() {
        return strike_count;
    }

    /**
     * Show hint
     * <p>
     * ex) 1볼 1스트라이크, ex) 1스트라이크
     * </p>
     *
     * @param player_number   : 사용자가 입력한 수
     * @param computer_number : 컴퓨터의 랜덤 수
     */
    public void showHint(String player_number, String computer_number) {
        //player_number와 computer_number비교
        compareAnswer(player_number, computer_number);

        StringBuilder result = new StringBuilder(); //출력할 결과

        // ball_count와 strike_count에 따라 result에 append
        if (ball_count != 0) {
            result.append(ball_count).append(BALL_WORD);
        }
        if (strike_count != 0 && ball_count != 0) {
            result.append(" ");
        }
        if (strike_count != 0) {
            result.append(strike_count).append(STRIKE_WORD);
        }
        if (result.isEmpty()) {
            result.append(NOT_THING_WORD);
        }

        System.out.println(result);
    }

    /**
     * compare player_number and computer_number
     * <p>
     * 플레이어가 입력한 수와 컴퓨터의 수를 비교하여 각각의 자리수에 따라 스트라이크 수와,
     * <br> 포함된 수에 따라 볼수를 증가하는 함수
     * </p>
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
            // player의 i번쨰 자리수와 컴퓨터의 i번째 자리수가 같을 경우(스트라이크)
            if (computer_number.charAt(i) == player_num) {
                increaseStrikeCount();
                continue;
            }
            increaseBallCount(); //그 외는 ball(player의 i번쨰 자리수가 컴퓨터의수에 포함되어 있을 경우)
        }
    }


}
