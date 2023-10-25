package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameState {
    private final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private final String REGAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private final int STATE_PLAY = 1;
    private final int STATE_TERMINATE = 2;

    int state;

    void gameStart() {
        System.out.println(START_MESSAGE);
        state = STATE_PLAY;
    }

    boolean isPlaying() {
        return (state == STATE_PLAY);
    }

    void askRegame() {
        System.out.println(REGAME_MESSAGE);
        String input = Console.readLine();
        validateInput(input);
    }

    private void validateInput(String input) {
        int inputState = Integer.parseInt(input);
        if (inputState == STATE_PLAY) {
            state = STATE_PLAY;
            return;
        }
        if (inputState == STATE_TERMINATE) {
            state = STATE_TERMINATE;
            return;
        }
        throw new IllegalArgumentException();
    }

}
