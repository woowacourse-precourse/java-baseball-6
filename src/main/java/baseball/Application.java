package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.utils.Utils;

public class Application {
    public static void main(String[] args) {
        Application app = new Application();
        Baseball baseball = new Baseball();

        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean exitFlag = false;
        while (!exitFlag) {
            baseball.run();
            exitFlag = app.askExit();
        }
        System.out.println("프로그램을 종료합니다.");
    }

    public boolean askExit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = readLine();
        Utils.validateStringOneOrTwo(userInput);
        if (userInput.equals("2")) {
            return true;
        }
        return false;
    }
}