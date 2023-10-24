package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final BaseballGame baseballGame = new BaseballGame();
    private static final String REPLAY_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final char REPLAY_GAME = '1';
    private static final char FINISH_GAME = '2';

    public static void main(String[] args) {
        while (true) {
            baseballGame.runGame();
            System.out.println(REPLAY_MESSAGE);
            boolean isReplayOrDone = isReplayOrDone();
            if (!isReplayOrDone) {
                break;
            }
        }
    }

    public static boolean isReplayOrDone() {
        String input = Console.readLine();

        if (input.length() == 1 && input.charAt(0) == REPLAY_GAME) {
            return true;
        } else if (input.length() == 1 && input.charAt(0) == FINISH_GAME) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }
}