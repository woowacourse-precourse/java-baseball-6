package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameView {
    private static final String GAME_CONTINUED = "1";
    private static final String GAME_STOPPED = "2";

    public void printStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public boolean askContinueGame() {
        boolean isContinued;
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if (input.equals(GAME_CONTINUED)) {
            isContinued = true;
        }
        else if (input.equals(GAME_STOPPED)){
            isContinued = false;
        }
        else {
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
        }
        return isContinued;
    }
}
