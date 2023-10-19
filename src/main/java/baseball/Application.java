package baseball;

import baseball.Game.BaseBallGame;
import baseball.Game.BaseBallGameImpl;

import static java.lang.System.*;


public class Application {

    private static final String startupMessage = "숫자 야구 게임을 시작합니다.";
    private static final BaseBallGame baseBallGame = new BaseBallGameImpl();

    public static void main(String[] args) {
        out.println(startupMessage);
        try{
            baseBallGame.initGame();
        } catch (IllegalArgumentException e) {
            out.println(e.getMessage());
            throw e;
        }
    }
}
