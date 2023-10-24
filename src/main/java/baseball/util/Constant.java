package baseball.util;

public class Constant {

    public static final int RANGE_DIGIT = 3;
    public static final int CMD_RESTART = 1;
    public static final int CMD_QUIT = 2;
    public static final int RANGE_ZERO = 0;

    public static class BaseballController{
        public static final int RANGE_START = 1;
        public static final int RANGE_END = 9;
        public static final String SPACE = "";
    }

    public static class InputView{
        public static final String START_MSG = "숫자 야구 게임을 시작합니다.";
        public static final String INPUT_MSG = "숫자를 입력해주세요 : ";

    }

    public static class OutputView{
        public static final String RESULT_NOTHING = "낫싱";
        public static final String RESULT_BALL = "볼";
        public static final String RESULT_STRIKE = "스트라이크";
        public static final String BLANK = " ";
        public static final String END_MSG = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        public static final String RESTART_MSG = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    }
}
