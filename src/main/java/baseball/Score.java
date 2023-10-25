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

    // game round score setter
    public void setScore(User user, Opponent opponent) {
        ballCounter = 0;
        strikeCounter = 0;

        List<Integer> userNumbers = user.getNumbers();
        List<Integer> opponentNumbers = opponent.getNumbers();

        setStrikeCounter(userNumbers, opponentNumbers);
        setBallCounter(userNumbers, opponentNumbers);
    }

    // game end condition: 3 strikes
    public boolean isOver(){
        return strikeCounter == 3;
    }

    // strike logic
    private void setStrikeCounter(List<Integer> userNumbers, List<Integer> opponentNumbers) {
        // strike condition: two numbers at list should match at exact position
        for (int i = 0; i < opponentNumbers.size(); i++) {
            int currentUserNumber = userNumbers.get(i);
            int currentOpponentNumber = opponentNumbers.get(i);

            if (currentUserNumber == currentOpponentNumber) {
                strikeCounter++;
            }
        }
    }

    // ball logic
    private void setBallCounter(List<Integer> userNumbers, List<Integer> opponentNumbers) {
        for (int i = 0; i < opponentNumbers.size(); i++) {
            int currentUserNumber = userNumbers.get(i);
            int currentOpponentNumber = opponentNumbers.get(i);

            // ball condition: opponent's list must contain identical number but at different index
            if (opponentNumbers.contains(currentUserNumber) && currentUserNumber != currentOpponentNumber) {
                ballCounter++;
            }
        }
    }
}
