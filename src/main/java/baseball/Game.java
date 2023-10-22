package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    public static void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        String computerNum = ComputerNumber.makeNumber();
        String userInput = UserInput.readUserInput();
        String userNum = UserInput.checkUserInput(userInput);
        HintCountDto hintCountDto = Hint.calHint(computerNum, userNum);
        boolean isGameDone = false;
        while (!isGameDone) {
            isGameDone = Hint.printHint(hintCountDto);
        }
    }

    public static void restartOrEnd() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String reply = Console.readLine();
        if (reply.equals("1")) {
            start();
        }
    }
}
