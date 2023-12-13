package baseball.dto;

public class ResultDto {
    private final int strike;
    private final int ball;

    public ResultDto(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public String noticeResult() {
        String result = "";

        if (ball != 0) {
            result += ball + "볼 ";
        }
        if (strike != 0) {
            result += strike + "스트라이크";
        }
        if (ball == 0 && strike == 0) {
            result = "낫싱";
        }

        return result.trim();
    }
}
