package baseball.service;

import baseball.domain.Computer;
import baseball.domain.ContinueAnswer;
import baseball.domain.GamePlayer;
import baseball.domain.Result;

import static baseball.domain.Const.FIXED_ANSWER_CIPHERS;

public class Service {
    private final GamePlayer gamePlayer = new GamePlayer();
    private final Computer computer = new Computer();
    private final Result result = new Result();
    private final ContinueAnswer continueAnswer = new ContinueAnswer();

    public void initComputer() {
        computer.generateThreeNumbers();
    }

    private void initData(String inputtedNumbers) {
        gamePlayer.initThreeNumbers(inputtedNumbers);
        result.initResult();
    }

    public Result calculateResult(String inputtedNumbers) {
        initData(inputtedNumbers);

        for (int index = 0; index < FIXED_ANSWER_CIPHERS; index++) {
            int gamePlayerNumber = gamePlayer.extractOneNumber(index);
            if (computer.isStrike(gamePlayerNumber, index)) result.addStrike();
            else if (computer.isBall(gamePlayerNumber, index)) result.addBall();
        }
        return result;
    }

    public ContinueAnswer generateContinueAnswer(String answerString) {
        continueAnswer.createAnswer(answerString);
        return continueAnswer;
    }
}