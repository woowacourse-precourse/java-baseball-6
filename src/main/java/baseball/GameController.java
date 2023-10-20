package baseball;


import static baseball.NumberBaseballGame.*;

public class GameController {
    private static final String initMessage = "숫자 야구 게임을 시작합니다.";

    public static void initNumberBaseballGame (){
        System.out.println(initMessage);
        initGame();
    }

}
