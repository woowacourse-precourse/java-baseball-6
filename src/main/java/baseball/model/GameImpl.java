package baseball.model;

import baseball.dto.GameResult;

import java.util.List;

public class GameImpl implements Game {

    private final List<Integer> answer;

    public GameImpl() {
        this.answer = makeAnswer();
    }

    @Override
    public GameResult compare(List<Integer> userInput) {
        int strike = 0;
        int ball = 0;
        for(int i = 0; i < 3; i++) {
            if (userInput.get(i) == answer.get(i))  strike++;
            else if (answer.contains(userInput.get(i))) ball++;
        }
        return new GameResult(strike, ball);
    }
}