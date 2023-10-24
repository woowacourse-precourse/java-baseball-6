package baseball.Computer;

import baseball.View.InputView;
import baseball.View.OutputView;

public class BallCount {
    public static int strikeCount=0;
    public static int ballCount=0;
    public static boolean Nashing = false;

    public static void Strike(){
        strikeCount++;
    }

    public static void Ball(){
        ballCount++;
    }

    public static void Nashing(){
        if(strikeCount==0 && ballCount==0){
            Nashing = true;
            OutputView.printNashing();
        }
    }

    public static void ResetCount(){
        strikeCount = 0;
        ballCount = 0;
    }
}
