package baseball;

import static java.lang.System.out;

import baseball.Config.DiContainer;
import baseball.ProcessGame.BaseBallGame;
import camp.nextstep.edu.missionutils.Console;


public class Application {

    private static final String startupMessage = "숫자 야구 게임을 시작합니다.";
    private static final BaseBallGame baseBallGame = DiContainer.getBaseBallGame();

    public static void main(String[] args) {
        out.println(startupMessage);
        try {
            baseBallGame.initGame();
        } catch (IllegalArgumentException e) {
            out.println(e.getMessage());
            throw e;
        } finally {
            Console.close();
        }
    }
}
