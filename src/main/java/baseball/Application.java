package baseball;

import baseball.utils.Utils;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean isFinish = false;
        while (!isFinish) {
            game.run();
            isFinish = isGameFinish();
        }
        System.out.println("프로그램을 종료합니다.");
    }

    public static boolean isGameFinish() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = Console.readLine();
        Utils.validateStringOneOrTwo(userInput);
        return userInput.equals("2");
    }
}
