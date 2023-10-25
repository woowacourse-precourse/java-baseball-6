package baseball.vo;

import baseball.service.InputConvertService;

public final class RestartDecisionCode {
    private final Integer code;

    public RestartDecisionCode(Integer code) {
        this.code = code;
    }

    public RestartDecisionCode makeRestartDecisionCode(InputConvertService inputConvertService) {
        Integer code = inputConvertService.convertInteger();
        return new RestartDecisionCode(code);
    }

    public boolean isDecisionCodeEqualOne() {
        return code.equals(1);
    }

    public boolean isDecisionCodeEqualTwo() {
        return code.equals(2);
    }
}
