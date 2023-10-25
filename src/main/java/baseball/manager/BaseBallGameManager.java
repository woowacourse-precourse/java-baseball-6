package baseball.manager;

import baseball.numbers.Numbers;
import baseball.numbers.NumbersFactory;
import baseball.score.Score;
import baseball.score.ScoreFactory;
import camp.nextstep.edu.missionutils.Console;

import static baseball.constant.Command.*;
import static baseball.constant.Error.*;
import static baseball.constant.Message.*;
import static baseball.constant.Rule.*;

public class BaseBallGameManager implements GameManager {

    private final NumbersFactory numbersFactory;
    private final ScoreFactory scoreFactory;

    public BaseBallGameManager(NumbersFactory numbersFactory, ScoreFactory scoreFactory) {
        this.numbersFactory = numbersFactory;
        this.scoreFactory = scoreFactory;
    }

    @Override
    public void play() {
        System.out.println(GAME_START.getMessage());
        do {
            executeBaseBallGame();
        } while (isRetry());
    }

    private void executeBaseBallGame() {
        Numbers computerNumbers = numbersFactory.createComputerNumbers();

        while (true) {
            System.out.print(NEED_USER_INPUT.getMessage());

            String input = Console.readLine();
            Numbers userNumbers = numbersFactory.createUserNumbers(input);

            Score score = scoreFactory.createScore(computerNumbers, userNumbers);

            System.out.println(score.toString());

            if (isSuccess(score)) {
                System.out.println(GAME_END.getGameEndMessage());
                break;
            }
        }
    }

    private boolean isSuccess(Score score) {
        int strikeCount = score.getStrike();
        return strikeCount == SIZE.getValue();
    }

    private void checkValidCommandAskRetry(String input) {
        if (input.equals(RETRY_GAME.getCommand()) || input.equals(END_GAME.getCommand()))
            return;

        throw new IllegalArgumentException(INPUT_ASK_RETRY.getMessage());
    }

    private boolean isRetry() {
        System.out.println(ASK_RETRY_GAME.getAskRetryMessage());

        String input = Console.readLine();
        checkValidCommandAskRetry(input);

        return input.equals(RETRY_GAME.getCommand());
    }

}
