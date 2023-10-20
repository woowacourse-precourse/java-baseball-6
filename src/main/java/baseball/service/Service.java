package baseball.service;

import baseball.domain.Computer;
import baseball.domain.ContinueAnswer;
import baseball.domain.GamePlayer;
import baseball.domain.Result;

import java.util.List;
import java.util.Objects;

import static baseball.domain.Const.FIXED_THREE_CIPHERS;

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
        List<Integer> gamePlayerNumbers = gamePlayer.getThreeNumbers();
        List<Integer> computerNumbers = computer.getThreeNumbers();

        for (int i = 0; i < FIXED_THREE_CIPHERS; i++) {
            if (Objects.equals(gamePlayerNumbers.get(i), computerNumbers.get(i))) result.addStrike();
            else if(computerNumbers.contains(gamePlayerNumbers.get(i))) result.addBall();
        }
        return result;
    }

    public ContinueAnswer generateContinueAnswer(String answerString) {
        continueAnswer.createAnswer(answerString);
        return continueAnswer;
    }
}
