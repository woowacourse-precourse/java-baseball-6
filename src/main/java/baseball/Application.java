package baseball;

import baseball.message.ConsoleMessage;
import baseball.utils.GameStatus;
import baseball.utils.GameUtils;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.io.IOException;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        while(true) {
            if(GameUtils.startGame() == GameStatus.EXIT) {
                break;
            }
        }
    }
}
