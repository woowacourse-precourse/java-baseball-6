package baseball;

import baseball.service.GameService;
import baseball.view.RequestInput;
import baseball.view.SystemMessage;
import camp.nextstep.edu.missionutils.Console;

public class Controller {

    public void run() throws IllegalArgumentException {
        setGame();
        startGame();
        endGame();
        askRetry();
    }

    private void setGame() {

        /**r게임 세팅을 한다**/;
    }

    private void startGame() throws IllegalArgumentException {
        /** 게임 시작을 진행한다 **/
    }

    private void endGame() {
        /** 게임을 끝낸다**/
    }

    private void askRetry() throws IllegalArgumentException {
        /** 만일 게임을 다시 시작하고 싶어하면 다시 시작할 수 있도록 물어본다**/
    }
}

