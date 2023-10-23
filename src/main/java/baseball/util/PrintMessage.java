package baseball.util;

import static baseball.util.Message.*;

public class PrintMessage {
    public static void printInitMessage(){
        System.out.println(INIT);
    }

    public static void printInputMessage(){
        System.out.print(INPUT);
    }
    public static void printBallMessage(int num){
        System.out.println(Integer.toString(num) + BALL);
    }

    public static void printStrikeMessage(int num){
        System.out.println(Integer.toString(num) + STRIKE);
    }

    public static void printSuccessMessage(){
        System.out.println(SUCCESS);
    }
}
