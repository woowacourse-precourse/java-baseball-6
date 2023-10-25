package baseball.mytest.model;

public class BaseballGame {
    public String restartGame(String input) {
        if (input.equals("1")) {
            return "재시작";
        }
        return "종료";
    }
}
