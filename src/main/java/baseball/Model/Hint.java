package baseball.Model;

import baseball.View.PlayGameView;
import java.util.List;

public class Hint {
    public static boolean isThreeBall = false;
    public static void compareNumber(List<Integer> computerNumber, List<Integer> playerInput) {
        isThreeBall = false;
        int ballCount = 0, strikeCount = 0;

        for (int i = 0; i < 3; i++) {
            int player = playerInput.get(i);
            if (player == computerNumber.get(i)) {
                strikeCount++;
            } else if (computerNumber.contains(player)) {
                ballCount++;
            }
        }
        if(strikeCount == 3)
            isThreeBall = true;
        PlayGameView.printHint(ballCount, strikeCount);
    }
}
