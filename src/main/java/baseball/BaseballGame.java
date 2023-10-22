package baseball;

import camp.nextstep.edu.missionutils.Console;


public class BaseballGame {
    private static boolean isEnd = false;
    private static UserInputHandler userInputHandler = new UserInputHandler();
    private static Baseball baseball;

    private BaseballGame() {}

    public static void play() {
        while(!isEnd) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            baseball = new Baseball();
            inplay();
            if (isReplayCondition()) {
                isEnd = true;
            }
        }
    }
    private static void inplay() {
        do {
            baseball.setBallCount(userInputHandler.takeInput());
        } while (!isEndCondition());
    }
    private static boolean isEndCondition() {
        if (baseball.isEndCount()) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
            return true;
        }
        return false;
    }
    private static boolean isReplayCondition() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Integer.parseInt(Console.readLine()) == 1;
    }
}
