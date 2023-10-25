package baseball.Model;

import baseball.View.PlayGameView;
import java.util.List;

public class Hint {
    public static boolean isThreeBall = false;
    public static void compareNumber(List<Integer> computerNumber, List<Integer> playerInput) {
        int ballCount = 0, strikeCount = 0;

        for (int i = 0; i < 3; i++) {
            if (playerInput.get(i).equals(computerNumber.get(i))) {
                strikeCount++;
            } else if (computerNumber.contains(playerInput.get(i))) {
                ballCount++;
            }
        }
        if(ballCount == 3)
            isThreeBall = true;
        PlayGameView.printHint(ballCount, strikeCount);
    }
}
