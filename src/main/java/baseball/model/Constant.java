package baseball.model;

public final class Constant {
    public final static int NUMBER_SIZE = 3;
    public final static int NUMBER_RANGE_START = 1;
    public final static int NUMBER_RANGE_END = 9;

    public final static String REPLAY_GAME = "1";
    public final static String END_GAME = "2";

    public final static String START = "숫자 야구 게임을 시작합니다.";
    public final static String END = "게임을 새로 시작하려면 " + REPLAY_GAME + ", 종료하려면 " + END_GAME + "를 입력하세요.";
    public final static String INPUT = "숫자를 입력해주세요 : ";
    public final static String BALL = "볼";
    public final static String STRIKE = "스트라이크";
    public final static String CORRECT = NUMBER_SIZE + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public final static String INCORRECT = "낫싱";
    public final static String WRONG_RANGE_NUMBER = "잘못된 범위의 숫자가 포함되어 있습니다.";
    public final static String WRONG_SIZE_NUMBER = "숫자의 자릿수가 잘못되었습니다.";
    public final static String WRONG_OVERLAP_NUMBER = "중복된 숫자가 포함되어 있습니다.";

    public final static boolean RUNNING = true;
    public final static boolean FINISHED = false;
}
