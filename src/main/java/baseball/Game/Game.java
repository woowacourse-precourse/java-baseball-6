package baseball.Game;

import baseball.Player.Batter;
import baseball.Player.Pitcher;

import java.util.List;

public class Game {

    private static final String START_GAME_GUIDE = "숫자 야구 게임을 시작합니다.";
    private static final String PROCEED_UNIT_GUIDE = "숫자를 입력해주세요 : ";
    private static final String END_UNIT_GUIDE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private static Boolean GAME_STATUS = true;

    private static Boolean UNIT_STATUS = true;
    private static Pitcher pitcher;
    private static Batter batter;

    public static void doGame(){
        startGame();
        while(GAME_STATUS){
            startUnit();
            proceedUnit();
            endUnit();
        }
    }

    public static void startGame(){
        System.out.println(START_GAME_GUIDE);
    }
    public static void startUnit(){
        pitcher = new Pitcher();
        batter = new Batter();

        pitcher.makeChoice();
    }

    public static void proceedUnit(){
        while(UNIT_STATUS){
            System.out.println(PROCEED_UNIT_GUIDE);
            batter.makeChoice();
        }
    }

    public static void endUnit(){
        System.out.println(END_UNIT_GUIDE);
        if(!batter.decideToPlayMore()) {
            GAME_STATUS = false;
        }
    }

}
