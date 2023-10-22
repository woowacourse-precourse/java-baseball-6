package baseball;

import camp.nextstep.edu.missionutils.Console;

import static baseball.Constant.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        do {
            Game game = new Game();
            game.play();
        } while (restart());
    }
    public static boolean restart() {
        System.out.println(RESTART_MESSAGE);
        String inputString = Console.readLine();
        if (inputString.equals(RESTART_STRING)) {
            return true;
        }
        else if (inputString.equals(TERMINATE_STRING)) {
            return false;
        }
        else {
            throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
        }
    }
}
