package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        final int NUMBER_OF_DIGITS = 3;

        final Store store = new Store();
        final Message message = new Message();
        final Game game = new Game(store, NUMBER_OF_DIGITS);

        // 게임 시작
        message.gameStart();

        // 정답 생성
        game.generateAnswer();

        // 숫자 입력
        store.saveInput(message.inputNumber());

        // 정답 비교
        game.compareAnswer();

        // 결과 출력
        message.printResult(store);

        // 정답 메시지 출력
        message.ifWin(store, NUMBER_OF_DIGITS);
    }

}
