package baseball.vo;

import static camp.nextstep.edu.missionutils.Console.readLine;

public final class RestartDecisionCode {
    private final Integer code;

    public RestartDecisionCode(Integer code) {
        this.code = code;
    }

    public RestartDecisionCode makeRestartDecisionCode() {
        int code = Integer.parseInt(readLine());
        return new RestartDecisionCode(code);
    }

    public boolean isDecisionCodeEqualOne() {
        return code.equals(1);
    }

    public boolean isDecisionCodeEqualTwo() {
        return code.equals(2);
    }
}
