package baseball.domain;

public class Manager {

    public static final String RESTART = "1";
    public static final String EXIT = "2";
    private String result;

    public Manager(String input) {
        if (input.equals(RESTART)) {
            result = "재시작";
        }
        if (input.equals(EXIT)) {
            result = "종료";
        }
    }

    public String getResult() {
        return result;
    }
}
