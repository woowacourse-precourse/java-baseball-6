package baseball.view;

import static constant.MessageList.*;

public class OutputView {
    public static void printGameStartMessage(){
        System.out.println(GAME_START_MESSAGE);
    }
    public static void printBallMessage(){
        System.out.print(BALL_MESSAGE);
    }
    public static void printStrikeMessage(){
        System.out.print(STRIKE_MESSAGE);
    }
    public static void printNothingMessage(){
        System.out.print(NOTHING_MESSAGE);
    }
    public static void printCount(int count){
        System.out.print(count);
    }
    public static void printSuccessMessage(){
        System.out.println(SUCCESS_MESSAGE);
    }

}
