package baseball.service.handler;

public class Hint {
    private static final String BALL_WORD = "볼";
    private static final String STRIKE_WORD = "스트라이크";
    private static final String NOT_THING_WORD = "낫싱";
    private Integer ballCount = 0, strikeCount = 0;   //볼과 스트라이크 수

    /**
     * strikeCount를 1만큼 증가
     */
    private void increaseStrikeCount() {
        this.strikeCount++;
    }

    /**
     * ballCount를 1만큼 증가
     */
    private void increaseBallCount() {
        this.ballCount++;
    }

    /**
     * Hint reset
     */
    public void resetHint() {
        this.ballCount = 0;
        this.strikeCount = 0;
    }

    /**
     * strikeCount getter
     *
     * @return strikeCount
     */
    public int getStrike() {
        return strikeCount;
    }

    /**
     * Show hint
     * <p>
     * ex) 1볼 1스트라이크, ex) 1스트라이크
     * </p>
     *
     * @param playerNumber   : 사용자가 입력한 수
     * @param computerNumber : 컴퓨터의 랜덤 수
     */
    public void showHint(String playerNumber, String computerNumber) {
        //playerNumber와 computerNumber비교
        compareAnswer(playerNumber, computerNumber);

        StringBuilder result = new StringBuilder(); //출력할 결과

        // ballCount와 strikeCount에 따라 result에 append
        if (ballCount != 0) {
            result.append(ballCount).append(BALL_WORD);
        }
        if (strikeCount != 0 && ballCount != 0) {
            result.append(" ");
        }
        if (strikeCount != 0) {
            result.append(strikeCount).append(STRIKE_WORD);
        }
        if (result.isEmpty()) {
            result.append(NOT_THING_WORD);
        }

        System.out.println(result);
    }

    /**
     * compare playerNumber and computerNumber
     * <p>
     * 플레이어가 입력한 수와 컴퓨터의 수를 비교하여 각각의 자리수에 따라 스트라이크 수와,
     * <br> 포함된 수에 따라 볼수를 증가하는 함수
     * </p>
     *
     * @param playerNumber   : 플레이어가 입력한 수
     * @param computerNumber : 컴퓨터가 랜덤으로 얻은 수
     */
    private void compareAnswer(String playerNumber, String computerNumber) {
        int length = playerNumber.length();
        //입력한 수의 자리수 만큼 반복
        for (int i = 0; i < length; i++) {
            char playerNum = playerNumber.charAt(i);  //i번쨰 자리수의 수
            //player의 i번쨰 자리수의 숫자가 컴퓨터의 수에 포함되어 있지 않으면 pass
            if (!computerNumber.contains(String.valueOf(playerNum))) {
                continue;
            }
            // player의 i번쨰 자리수와 컴퓨터의 i번째 자리수가 같을 경우(스트라이크)
            if (computerNumber.charAt(i) == playerNum) {
                increaseStrikeCount();
                continue;
            }
            increaseBallCount(); //그 외는 ball(player의 i번쨰 자리수가 컴퓨터의수에 포함되어 있을 경우)
        }
    }


}
