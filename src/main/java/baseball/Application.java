package baseball;

import baseball.logic.User;
import baseball.utils.Utils;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        Application app = new Application();
        Game game = new Game();

        System.out.println("숫자 야구 게임을 시작합니다.");
        do {
            User.run();
        } while (!app.gameRestart());
        System.out.println("프로그램을 종료합니다.");
    }

    public boolean gameRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = readLine();
        Utils.validateStringThreeDifferentDigits(userInput);
        if (userInput.equals("1")) {
            return false;
        } else {
            return true;
        }
    }
}
