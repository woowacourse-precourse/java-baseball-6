package baseball.controller;

import camp.nextstep.edu.missionutils.Console;

/**
 * 유저의 입출력을 처리하는 컨트롤러
 */
public class GameController {

    public String getUserInput() {
        return Console.readLine();
    }
}
