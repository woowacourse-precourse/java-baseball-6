package baseball.view;

import javax.swing.*;
import java.util.List;

public class OutputView {
    private static final String START_GAME = "숫자 야구 게임을 시작합니다.";
    private static final String THREE_STRIKE="3개의 숫자를 모두 맞추셨습니다! 게임 종료";
    private static final String GAME_END = "게임 종료";

    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";
    private static final Integer ZERO = 0;
    public static void ResultView(int ballCount,int strikeCount) {
        ball(ballCount);
        strike(strikeCount);
        nothing(ballCount,strikeCount);
    }

    private static void nothing(int ballCount, int strikeCount) {
        if(ballCount == ZERO && strikeCount == ZERO)
            System.out.print(NOTHING);
    }

    private static void strike(int strikeCount) {
        if(strikeCount>ZERO)
            System.out.print(strikeCount+STRIKE);
    }

    private static void ball(int ballCount) {
        if(ballCount>ZERO)
            System.out.print(ballCount+BALL);
    }
    public static void gameStartMessage(){
        System.out.println(START_GAME);
    }
    public static void gameResultMessage(){
        System.out.println(THREE_STRIKE);
    }
    public static void gameEndMessage(){
        System.out.println(GAME_END);
    }


}
