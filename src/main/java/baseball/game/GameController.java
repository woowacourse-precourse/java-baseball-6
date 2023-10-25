package baseball.game;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GameController {
    private final List<Integer> answer = new ArrayList<>();
    private int strike = 0;
    private int ball = 0;

    public GameController() {
        while (this.answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!this.answer.contains(randomNumber)) {
                this.answer.add(randomNumber);
            }
        }
    }

    private void clearStrikeAndBall() {
        this.strike = 0;
        this.ball = 0;
    }

    protected void isStrikeOrBall(List<Integer> userInput) {

        if (userInput.equals(answer)) {
            this.strike = 3;
            return;
        }

        for (int i = 0; i < userInput.size(); i++) {
            if (answer.get(i).equals(userInput.get(i))) {
                this.strike++;
            } else if (answer.contains(userInput.get(i))) {
                this.ball++;
            }
        }
    }

    protected boolean printResultPhrase() {
        if (strike == 3) {
            GamePhrases.strikePhrase(strike);
            GamePhrases.answerPhrase();
            GamePhrases.endPhrase();
            return false;
        } else if ((strike + ball) == 0) {
            GamePhrases.outPhrase();
        } else if (strike != 0 && ball != 0) {
            GamePhrases.ballAndStrikePhrase(strike, ball);
            clearStrikeAndBall();
        } else if (strike > 0) {
            GamePhrases.strikePhrase(strike);
            clearStrikeAndBall();
        } else if (ball > 0) {
            GamePhrases.ballPhrase(ball);
            clearStrikeAndBall();
        }
        return true;
    }
}
