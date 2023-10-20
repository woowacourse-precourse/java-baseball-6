package baseball.game.system;

import camp.nextstep.edu.missionutils.Console;

public class ReplayableGameSystemConsoleView implements ReplayableGameSystemView {

    private static final String REQUEST_REPLAY_PROMPT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String RESTART = "1";
    private static final String EXIT = "2";

    @Override
    public boolean requestReplayInput() {
        System.out.println(REQUEST_REPLAY_PROMPT);
        return parseInput(Console.readLine());
    }

    private boolean parseInput(String input) {
        if (input.equals(RESTART)) {
            return true;
        }

        if (input.equals(EXIT)) {
            return false;
        }

        throw new IllegalArgumentException();
    }
}
