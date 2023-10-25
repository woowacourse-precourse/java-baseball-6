package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
    private boolean isEnd;
    private final UserInputHandler userInputHandler = new UserInputHandler();
    private static Baseball baseball;

    public BaseballGame() {
        this.isEnd = false;
    }

    public void play() {
        while(!isEnd) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            baseball = new Baseball();
            inplay();
            if (!isReplayCondition()) {
                isEnd = true;
            }
        }
        System.out.println("게임 종료");
    }
    private void inplay() {
        do {
            baseball.readBallCount(userInputHandler.takeInput());
        } while (!isEndCondition());
    }
    private boolean isEndCondition() {
        if (baseball.isEndCount()) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
            return true;
        }
        return false;
    }
    private boolean isReplayCondition() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Integer.parseInt(Console.readLine()) == 1;
    }
}
