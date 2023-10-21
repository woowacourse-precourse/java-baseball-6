package baseball;

import java.util.List;

public final class MessageConstant {
    public static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String REQUEST_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String SUCCESS_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String RESTART_OR_STOP_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static final String CONTROL_SIGN_LENGTH_EXCEPTION_MSG = "하나의 숫자만 입력해 주세요.";
    public static final String CONTROL_SIGN_NUMBER_EXCEPTION_MSG = "재시작은 1, 게임 종료는 2입니다.";

    public static final String INPUT_CONTAIN_ZERO_EXCEPTION_MSG = "1 ~ 9 사이의 숫자만 입력해주세요.";
    public static final String INPUT_DUPLICATION_EXCEPTION_MSG = "중복된 수는 입력할 수 없습니다.";
    public static final String INPUT_NOT_ONLY_DIGIT_EXCEPTION_MSG = "숫자만 입력해 주세요.";
    public static final String INPUT_LENGTH_EXCEPTION_MSG = "3개의 숫자만 입력해주세요.";

    public String scoreMessage(List<Integer> score) {
        final int ball = score.get(0);
        final int strike = score.get(1);

        if (ball == 0 && strike > 0) {
            return (strike + "스트라이크");
        }
        if (ball > 0 && strike == 0) {
            return (ball + "볼");
        }
        if (ball == 0 && strike == 0) {
            return ("낫싱");
        }
        return (ball + "볼 " + strike + "스트라이크");
    }
}
