package baseball.Domain;

import baseball.Dto.Result;

public class CreateResultData {
    public String createResultDate() {
        Result result = Result.getInstance();
        return requestResult(result.requestStrike(), result.requestBall());
    }

    public boolean distinguishResult() {
        Result result = Result.getInstance();
        return result.requestStrike() == 3;
    }

    private String requestResult(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            return "낫싱";
        }

        StringBuilder resultString = new StringBuilder();
        ballResult(ball, resultString);
        strikeResult(strike, resultString);
        return resultString.toString().trim();
    }

    private void ballResult(int ball, StringBuilder resultString) {
        if (ball > 0) {
            resultString.append(ball).append("볼 ");
        }
    }

    private void strikeResult(int strike, StringBuilder resultString) {
        if (strike > 0) {
            resultString.append(strike).append("스트라이크");
        }
    }
}
