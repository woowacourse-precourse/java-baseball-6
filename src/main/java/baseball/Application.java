package baseball;

import baseball.user.ConsoleUser;
import baseball.user.User;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        User user = new ConsoleUser();
        user.doGame("start", 0);
    }
}
