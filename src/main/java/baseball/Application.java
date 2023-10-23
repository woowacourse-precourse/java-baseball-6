package baseball;

import baseball.core.GameHost;
import baseball.core.NumberPicker;
import baseball.core.participant.Opponent;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameHost gameHost = GameHost.createGameHost();
        gameHost.gameStart();
    }
}
