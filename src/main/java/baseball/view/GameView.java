package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class GameView {
    private static final String GAME_CONTINUED = "1";
    private static final String GAME_STOPPED = "2";

    public void printStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public boolean askContinueGame() {
        printEnd();
        String input = Console.readLine();
        validateInput(input);
        return isContinued(input);
    }

    private void printEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    private void validateInput(String input) {
        if (!input.equals(GAME_CONTINUED) && !input.equals(GAME_STOPPED)) {
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
        }
    }

    private boolean isContinued(String input) {
        return input.equals(GAME_CONTINUED);
    }
}
