package baseball.view;

import baseball.controller.BaseballGame;
import baseball.controller.Foul;
import camp.nextstep.edu.missionutils.Console;

public class BaseballStadium {
    public static void run() {
        String start = "1";

        String result = "";

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (start.equals("1")) {
            BaseballGame.pitcherPitch();
            while (!result.equals("3스트라이크")) {
                result = BaseballGame.compareNumbers(inputNum());
                System.out.println(result);
            }
            result = "";

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            start = contineGame();
        }
    }

    public static String inputNum() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        Foul.validateInputHitter(input);
        return input;
    }

    public static String contineGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        Foul.validateInputContine(input);
        return input;
    }
}
