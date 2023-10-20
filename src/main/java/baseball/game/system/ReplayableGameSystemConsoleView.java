package baseball.game.system;

import camp.nextstep.edu.missionutils.Console;

public class ReplayableGameSystemConsoleView implements ReplayableGameSystemView {

    private static final String RESTART = "1";
    private static final String EXIT = "2";
    private static final String REQUEST_REPLAY_PROMPT = "게임을 새로 시작하려면 " + RESTART +
            ", 종료하려면 " + EXIT + "를 입력하세요.";

    @Override
    public boolean requestReplayInput() {
        System.out.println(REQUEST_REPLAY_PROMPT);
        String input = Console.readLine();
        validInput(input);
        return parseInput(input);
    }

    private void validInput(String input) {
        if (!input.equals(RESTART) && !input.equals(EXIT)) {
            throw new IllegalArgumentException("입력은 " + RESTART + " 이거나 " + EXIT + " 여야 합니다.");
        }
    }

    private boolean parseInput(String input) {
        if (input.equals(RESTART)) {
            return true;
        }

        return false;
    }
}
