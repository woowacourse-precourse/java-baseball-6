package baseball;

public class BaseballUtil {

    public static final int MAX = 3;
    public static final String REGEX_NUMBER = "[1-9]{3}";
    public static final String[][] STRIKE_BALL = {
        {"낫싱", "1볼", "2볼", "3볼"},
        {"1스트라이크", "1볼 1스트라이크", "1볼 2스트라이크", ""},
        {"2스트라이크", "1볼 2스트라이크", "", ""},
        {"3스트라이크", "", "", ""}};
}
