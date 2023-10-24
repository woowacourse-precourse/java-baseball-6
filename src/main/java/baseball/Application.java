package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.Controller.GameRunner;
import baseball.domain.Baseball;
import baseball.utils.Utils;

public class Application {
    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean isContinue = true;

        while (isContinue) {
            Baseball baseball = new Baseball(Utils.createRandomNumberList(3));
            GameRunner gameRunner = new GameRunner(baseball);
            gameRunner.run();
            isContinue = askContinue();
        }
        System.out.println("프로그램을 종료합니다.");
    }

    private static boolean askContinue() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String userInput = readLine();
        Utils.validateRestartOrExitInput(userInput);
        return isContinue(userInput);
    }

    private static boolean isContinue(String userInput) {
        return !userInput.equals("2");
    }
}
