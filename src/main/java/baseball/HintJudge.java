package baseball;

import java.util.List;

public class HintJudge {

    public GuessStatus calculateStrikeBall(List<Integer> guessList, List<Integer> targetList) {
        GuessStatus guessStatus = new GuessStatus();
        for (int i = 0; i < 3; i++) {
            int inputEachNumber = guessList.get(i);
            if (inputEachNumber == targetList.get(i)) {
                guessStatus.addStrike();
            } else if (targetList.contains(inputEachNumber)) {
                guessStatus.addBall();
            }
        }
        return guessStatus;
    }
}
