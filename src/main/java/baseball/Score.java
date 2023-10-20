package baseball;
import baseball.player.Opponent;
import baseball.player.User;

import java.util.List;

public class Score {

    private int ballCounter;
    private int strikeCounter;

    public int getBallCounter() {
        return ballCounter;
    }

    public int getStrikeCounter() {
        return strikeCounter;
    }

    // game round score setter logic
    public void setScore(User user, Opponent opponent) {
        ballCounter = 0;
        strikeCounter = 0;

        List<Integer> userNumberList = user.getNumberList();
        List<Integer> opponentNumberList = opponent.getNumberList();

        // strike condition: two numbers at list should match at exact position
        for (int i = 0; i < opponentNumberList.size(); i++) {
            int currentUserNumber = userNumberList.get(i);
            int currentOpponentNumber = opponentNumberList.get(i);

            if (currentUserNumber == currentOpponentNumber) {
                strikeCounter++;
            }
        }

        for (int i = 0; i < opponentNumberList.size(); i++) {
            int currentUserNumber = userNumberList.get(i);
            int currentOpponentNumber = opponentNumberList.get(i);

            // ball condition: opponent's list must contain identical number but at different index
            if (opponentNumberList.contains(currentUserNumber) && currentUserNumber != currentOpponentNumber) {
                ballCounter++;
            }
        }
    }

    // game end condition: 3 strikes
    public boolean isOver(){
        return strikeCounter == 3;
    }

}
