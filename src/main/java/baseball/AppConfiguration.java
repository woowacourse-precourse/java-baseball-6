package baseball;

import baseball.manager.BaseBallGameManager;
import baseball.numbers.NumbersFactory;
import baseball.score.ScoreFactory;

public class AppConfiguration {

    NumbersFactory numbersFactory() {
        return new NumbersFactory();
    }

    ScoreFactory scoreFactory() {
        return new ScoreFactory();
    }

    BaseBallGameManager gameManager() {
        return new BaseBallGameManager(numbersFactory(), scoreFactory());
    }

}
