package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameView {
    ExceptionHandler exceptionHandler = new ExceptionHandler();

    public void printStartGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printExitGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public String inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();
        exceptionHandler.validateUserInput(userInput);
        return userInput;
    }

    public boolean inputRestartOption() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String option = Console.readLine();
        exceptionHandler.validateRestartOption(option);
        if (option.equals("1")) {
            return true;
        } else if (option.equals("2")) {
            return false;
        }
        return false;
    }

    public boolean checkAndPrintResult(Game game) {
        // 1. 성공한 경우 - true
        if (game.checkSuccess()) {
            System.out.println("3스트라이크");
            return true;
        } // 2. 하나도 없는 경우 - false
        else if (game.checkNothing()) {
            System.out.println("낫싱");
        } // 3. 힌트가 필요한 경우 - false
        else if (game.checkHint()) {
            System.out.println(game.getHint());
        }
        return false;
    }
}
