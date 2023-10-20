package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean exitFlag = false;

        while(!exitFlag) {

            Game game = new Game();
            game.play();

            exitFlag = askExit();
        }
        System.out.println("게임을 종료합니다.");
    }

    public static boolean askExit() {

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String userInput = Console.readLine();

        Util.validateExitCode(userInput);

        if(userInput.equals("2")) {
            return true;
        }

        return false;
    }
}
