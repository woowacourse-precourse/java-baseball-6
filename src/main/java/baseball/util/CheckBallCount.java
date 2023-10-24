package baseball.util;

import baseball.view.OutputMessage;
public class CheckBallCount {
    public boolean strikeOut (int[] count){
        OutputMessage outputMessage = new OutputMessage();
        if (count[1] == 3) {
            outputMessage.correctMessage();
            return true;
        }
        return false;
    }
}
