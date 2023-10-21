package Constant;

public abstract class Ment {
    private static String Nothing="낫싱";
    private static String Strike="스트라이크";
    private static String Ball="볼";
    private static String MentInput="숫자를 입력해주세요:";
    private static String MentClear="3개의 숫자 모두 맞히셨습니다! 게임 종료";
    private static String MentRestart="게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static String getMentClear() {
        return MentClear;
    }

    public static String getMentRestart() {
        return MentRestart;
    }

    public static String getNothing() {
        return Nothing;
    }

    public static String getStrike() {
        return Strike;
    }

    public static String getBall() {
        return Ball;
    }

    public static String getMentInput() {
        return MentInput;
    }
}
